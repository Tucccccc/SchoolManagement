package com.example.diemdanh.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.diemdanh.dto.FacultyDTO;
import com.example.diemdanh.entity.Faculty;
import com.example.diemdanh.global.common.CommonMethods;
import com.example.diemdanh.repository.FacultyRepository;
import com.example.diemdanh.service.FacultyService;

import jakarta.transaction.Transactional;

@Service
public class FacultyServiceImplement implements FacultyService{
	@Autowired
	private FacultyRepository faFacultyRepository;

	private CommonMethods common = new CommonMethods();
	
	// * addFaculty
	// Input: FacultyDTO facultyRequest
	// Output: FacultyDTO
	// Giang Ngo Truong 24/03/2025
	@Transactional
	@Override
	public FacultyDTO addFaculty(FacultyDTO facultyRequest) {
		FacultyDTO facultyResp = new FacultyDTO();
		try {
			// Create faculty
			Faculty faculty = common.createFaculty(facultyRequest);
			
			// Save faculty
			Faculty facultyResult = faFacultyRepository.save(faculty);
			
			if(facultyResult == null || facultyResult.getId() == null) {
				throw new IllegalStateException("Faculty save fail");
			}
			
			// Set response JSON
			facultyResp.setFaculty(facultyResult);
			facultyResp.setIntStatusCode(200);
			facultyResp.setStrMsg("Faculty save successfully!");
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Data Integrity Exception: " + e);
		} catch(Exception e) {
			throw new RuntimeException("An Exception has occurred", e);
		}
		
		return facultyResp;
	}

	// * getAllFaculty
	// Input: 
	// Output: FacultyDTO
	// Giang Ngo Truong 24/03/2025
	@Override
	public FacultyDTO getAllFaculty() {
		FacultyDTO facultyDTO = new FacultyDTO();
		try {
			List<Faculty> lstResult = faFacultyRepository.findAll();
			if(!lstResult.isEmpty()) {
				facultyDTO.setLstFaculty(lstResult);
				facultyDTO.setIntStatusCode(200);
				facultyDTO.setStrMsg("Success");
			} else {
				facultyDTO.setIntStatusCode(404);
				facultyDTO.setStrMsg("Faculty not found");
			}
			return facultyDTO;
		}
		catch(Exception e) {
			facultyDTO.setIntStatusCode(500);
			facultyDTO.setStrError("An error occurred: " + e.getMessage());
			return facultyDTO;
		}
	}
	
}
