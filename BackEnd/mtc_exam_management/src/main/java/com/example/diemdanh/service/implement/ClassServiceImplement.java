package com.example.diemdanh.service.implement;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.example.diemdanh.dto.dtoenum.ClassStatus;
import com.example.diemdanh.dto.mapper.MapperComponentHelper;
import com.example.diemdanh.dto.request.create.CreateClassRequest;
import com.example.diemdanh.dto.request.update.UpdateClassRequest;
import com.example.diemdanh.dto.response.ClassResponse;
import com.example.diemdanh.entity.ClassEntity;
import com.example.diemdanh.entity.Student;
import com.example.diemdanh.global.common.CommonMethods;
import com.example.diemdanh.repository.ClassRepository;
import com.example.diemdanh.repository.StudentRepository;
import com.example.diemdanh.service.ClassService;

@Service
public class ClassServiceImplement implements ClassService {
	private final ClassRepository classRepository;
	private final StudentRepository studentRepository;
	private final MapperComponentHelper mapperClassComponent;
	
	private CommonMethods common = new CommonMethods();

	public ClassServiceImplement(ClassRepository classRepository, StudentRepository studentRepository,
			MapperComponentHelper mapperClassComponent) {
		super();
		this.classRepository = classRepository;
		this.studentRepository = studentRepository;
		this.mapperClassComponent = mapperClassComponent;
	}

	// * Add Class
	// Input: ClassDTO addClass
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ClassResponse addClass(CreateClassRequest createClassRequest) {
		ClassResponse classDTOResp = new ClassResponse();
		// Create class
		ClassEntity classEntity = common.createClass(createClassRequest);

		// Save class
		ClassEntity classResult = classRepository.save(classEntity);

		if (classResult == null || classResult.getId() == null) {
			throw new IllegalStateException("An Error Occurrued");
		}

		// Set response JSON
		classDTOResp = mapperClassComponent.convertClassToDTO(classEntity);

		return classDTOResp;
	}

	// * Get all Class
	// Input:
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	@Transactional(readOnly = true)
	@Override
	public List<ClassResponse> getAllClass() {
        List<ClassResponse> classes = classRepository.findAll().stream()
                .map(mapperClassComponent::convertClassToDTO)
                .collect(Collectors.toList());
        
        if (classes.isEmpty()) {
            return classes;
        }
        
        return classes;
	}
	
	// * Update Class
	// Input:
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ClassResponse updateClass(Long id, UpdateClassRequest updateClassRequest) {
		ClassEntity classEntity = classRepository.findById(id).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Class not found")
			);
		
		if(!common.compareStrings(classEntity.getClassName(), updateClassRequest.getStrClassName())) {
			classEntity.setClassName(updateClassRequest.getStrClassName());
		}
		if(!common.compareStrings(classEntity.getClassDescription(), updateClassRequest.getStrClassDescription())) {
			classEntity.setClassDescription(updateClassRequest.getStrClassDescription());
		}
		if(!common.compareStrings(String.valueOf(classEntity.getStatus()), String.valueOf(updateClassRequest.getStatus()))) {
			classEntity.setStatus(updateClassRequest.getStatus());
		}
		
		classRepository.save(classEntity);
		
		ClassResponse classResponse = mapperClassComponent.convertClassToDTO(classEntity);
		
		return classResponse;
	}

	// * Get Class by ID
	// Input: Long Id
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	@Transactional(readOnly = true)
	@Override
	public ClassResponse getClassById(Long Id) {
		return classRepository.findById(Id).map(classObject -> {
			ClassResponse classDTO = new ClassResponse();
			classDTO.setId(classObject.getId());
			classDTO.setClassName(classObject.getClassName());
			classDTO.setClassDescription(classObject.getClassDescription());
			classDTO.setStatus(classObject.getStatus());
			classDTO.setCreatedAt(classObject.getCreatedAt());
			classDTO.setUpdatedAt(classObject.getUpdatedAt());
			return classDTO;
		}).orElseGet(() -> {
			return null;
		});
	}
	
	// * Delete Class by ID
	// Input: Long Id
	// Output: ResponseData<ClassResponse>
	// Giang Ngo Truong 18/09/2025
	@Override
	public ClassResponse deleteClassById(Long id) {
		ClassResponse classResponse = new ClassResponse();
		Optional<ClassEntity> optionClassEntity = classRepository.findById(id);
        if (optionClassEntity.isEmpty()) {
            return null;
        }
        
        try {
        	ClassEntity classEntity = optionClassEntity.get();
        	classEntity.setStatus(ClassStatus.INACTIVE);
        	classRepository.save(classEntity);
            
            classResponse = mapperClassComponent.convertClassToDTO(classEntity);
            return classResponse;
            
        } catch (Exception e) {
            return classResponse;
        }
	}
	

	// * assignStudentToClass
	// Input: List<Long> lstIdStudent, Long classId
	// Output: Boolean isSuccess
	// Giang Ngo Truong 02/04/2025
	@Transactional(rollbackFor = Exception.class)
	@Override
	public void assignStudentToClass(List<Long> lstIdStudent, Long classId) {
		List<Student> lstStudent = studentRepository.findAllById(lstIdStudent);

		if (lstStudent.isEmpty() || lstStudent.size() != lstIdStudent.size()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
		}

		ClassEntity classToAssign = classRepository.findById(classId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "An Error Occurrued"));

		for (Student student : lstStudent) {
			student.setHomeRoomClass(classToAssign);
		}

		studentRepository.saveAll(lstStudent);
	}
}