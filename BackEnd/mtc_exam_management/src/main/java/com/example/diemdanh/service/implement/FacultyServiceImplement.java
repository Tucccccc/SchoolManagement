package com.example.diemdanh.service.implement;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diemdanh.dto.mapper.MapperComponentHelper;
import com.example.diemdanh.dto.request.create.CreateFacultyRequest;
import com.example.diemdanh.dto.response.FacultyResponse;
import com.example.diemdanh.entity.Faculty;
import com.example.diemdanh.global.common.CommonMethods;
import com.example.diemdanh.repository.FacultyRepository;
import com.example.diemdanh.service.FacultyService;

@Service
public class FacultyServiceImplement implements FacultyService {
	private final FacultyRepository faFacultyRepository;
	private final MapperComponentHelper mapperFacultyComponent;

	private CommonMethods common = new CommonMethods();

	public FacultyServiceImplement(FacultyRepository faFacultyRepository,
			MapperComponentHelper mapperFacultyComponent) {
		this.faFacultyRepository = faFacultyRepository;
		this.mapperFacultyComponent = mapperFacultyComponent;
	}

	// * addFaculty
	// Input: FacultyDTO facultyRequest
	// Output: FacultyDTO
	// Giang Ngo Truong 24/03/2025
	@Transactional(rollbackFor = Exception.class)
	@Override
	public FacultyResponse addFaculty(CreateFacultyRequest facultyRequest) {
		FacultyResponse facultyResp = new FacultyResponse();

		// Create faculty
		Faculty faculty = common.createFaculty(facultyRequest);

		// Save faculty
		Faculty facultyResult = faFacultyRepository.save(faculty);

		if (facultyResult == null || facultyResult.getId() == null) {
			throw new IllegalStateException("An Error Occurrued");
		}

		// Set response JSON
		facultyResp = mapperFacultyComponent.convertFacultyToDTO(facultyResult);

		return facultyResp;
	}

	// * getAllFaculty
	// Input:
	// Output: FacultyDTO
	// Giang Ngo Truong 24/03/2025
	@Override
	public List<FacultyResponse> getAllFaculty() {
		List<FacultyResponse> faculties = faFacultyRepository.findAll().stream()
				.map(mapperFacultyComponent::convertFacultyToDTO)
				.collect(Collectors.toList());
		if (faculties.isEmpty()) {
			return faculties;
		}
		return faculties;
	}
}
