package com.example.diemdanh.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diemdanh.dto.ClassDTO;
import com.example.diemdanh.entity.ClassEntity;
import com.example.diemdanh.global.common.CommonMethods;
import com.example.diemdanh.repository.ClassRepository;
import com.example.diemdanh.service.ClassService;

@Service
public class ClassServiceImplement implements ClassService {
	@Autowired
	private ClassRepository classRepository;

	private CommonMethods common = new CommonMethods();

	// * Add Class
	// Input: ClassDTO addClass
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	@Transactional(rollbackFor = Exception.class)
	@Override
	public ClassDTO addClass(ClassDTO classRequest) {
		ClassDTO classDTOResp = new ClassDTO();
		// Create class
		ClassEntity classEntity = common.createClass(classRequest);

		// Save class
		ClassEntity classResult = classRepository.save(classEntity);

		if (classResult == null || classResult.getId() == null) {
			throw new IllegalStateException("Class save fail");
		}

		// Set response JSON
		classDTOResp.setIntStatusCode(200);
		classDTOResp.setStrMsg("Class saved successfully");
		classDTOResp.setClassEntity(classResult);

		return classDTOResp;
	}

	// * Get all Class
	// Input:
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	@Transactional(readOnly = true)
	@Override
	public ClassDTO getAllClass() {
		List<ClassEntity> lstClass = classRepository.findAll();

		return Optional.ofNullable(lstClass).filter(list -> !list.isEmpty()).map(list -> {
			ClassDTO classDTO = new ClassDTO();
			classDTO.setLstClass(lstClass);
			classDTO.setIntStatusCode(200);
			classDTO.setStrMsg("Success");
			classDTO.setIsFound(true);
			return classDTO;
		}).orElseGet(() -> {
			ClassDTO classDTO = new ClassDTO();
			classDTO.setIntStatusCode(404);
			classDTO.setStrMsg("No users found");
			classDTO.setIsFound(false);
			return classDTO;
		});
	}

	// * Get Class by ID
	// Input: Long Id
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	@Transactional(readOnly = true)
	@Override
	public ClassDTO getClassById(Long Id) {
		return classRepository.findById(Id).map(user -> {
			ClassDTO classDTO = new ClassDTO();
			classDTO.setIntStatusCode(200);
			classDTO.setStrMsg("Success");
			classDTO.setClassEntity(user);
			classDTO.setIsFound(true);
			return classDTO;
		}).orElseGet(() -> {
			ClassDTO classDTO = new ClassDTO();
			classDTO.setIntStatusCode(404);
			classDTO.setStrMsg("Class not found");
			classDTO.setIsFound(false);
			return classDTO;
		});
	}

	// * assignStudentToClass
	// Input: List<Long> lstIdStudent, Long classId
	// Output: Boolean iSuccess
	// Giang Ngo Truong 02/04/2025
	@Transactional(rollbackFor = Exception.class)
	@Override
	public Boolean assignStudentToClass(List<Long> lstIdStudent, Long classId) {
		for(Long id : lstIdStudent) {
			
		}
		return null;
	}
}