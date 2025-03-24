package com.example.diemdanh.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.example.diemdanh.dto.ClassDTO;
import com.example.diemdanh.entity.ClassEntity;
import com.example.diemdanh.global.common.CommonMethods;
import com.example.diemdanh.repository.ClassRepository;
import com.example.diemdanh.service.ClassService;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class ClassServiceImplement implements ClassService{
	@Autowired
	private ClassRepository classRepository;
	
	private CommonMethods common = new CommonMethods();
	
	// * Add Class
	// Input: ClassDTO addClass
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	@Transactional
	@Override
	public ClassDTO addClass(ClassDTO classRequest) {
		ClassDTO classDTOResp = new ClassDTO();
		try {
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
		} catch(DataIntegrityViolationException e) {
			throw new DataIntegrityViolationException("Data Integrity Exception", e);
		} catch(Exception e) {
			throw new RuntimeException("An Exception has occurred", e);
		}
		
		return classDTOResp;
	}
	
	// * Get all Class
	// Input:
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	@Override
	public ClassDTO getAllClass() {
		ClassDTO classDTO = new ClassDTO();
		
		try {
			List<ClassEntity> result = classRepository.findAll();
			if(!result.isEmpty()) {
				classDTO.setLstClass(result);
				classDTO.setIntStatusCode(200);
				classDTO.setStrMsg("Success");
			} else {
				classDTO.setIntStatusCode(404);
				classDTO.setStrMsg("No users found");
			}
			return classDTO;
		} catch (Exception e) {
			classDTO.setIntStatusCode(500);
			classDTO.setStrError("An error occurred: " + e.getMessage());
			return classDTO;
		}
	}
	
	// * Get Class by ID
	// Input: Long Id
	// Output: ClassDTO ClassDTO
	// Giang Ngo Truong 17/03/2025
	@Override
	public ClassDTO getClassById(Long Id) {
		ClassDTO classDTO = new ClassDTO();
		
		try {
			ClassEntity result = classRepository.findById(Id).orElseThrow(() -> new EntityNotFoundException("Class not found"));
			classDTO.setIntStatusCode(200);
			classDTO.setStrMsg("Success");
			classDTO.setClassEntity(result);
			return classDTO;
		} catch (Exception e) {
			classDTO.setIntStatusCode(500);
			classDTO.setStrError("An error occurred: " + e.getMessage());
			return classDTO;
		}
	}
}
