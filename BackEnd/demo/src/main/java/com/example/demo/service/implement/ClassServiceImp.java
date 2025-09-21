package com.example.demo.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.request.ClassRequest;
import com.example.demo.dto.response.ClassResponse;
import com.example.demo.entity.ClassEntity;
import com.example.demo.repository.ClassRepository;
import com.example.demo.service.ClassService;
import com.example.diemdanh.global.common.CommonMethods;

@Service
public class ClassServiceImp implements ClassService {
	@Autowired
	private ClassRepository classRepository;
	
	private CommonMethods common = new CommonMethods();

	@Override
	public ClassResponse addClass(ClassRequest classRequest) {
		ClassResponse classDTOResp = new ClassResponse();
		// Create class
		ClassEntity classEntity = common.createClass(classRequest);

		// Save class
		ClassEntity classResult = classRepository.save(classEntity);

		if (classResult == null || classResult.getId() == null) {
			throw new IllegalStateException("An Error Occurrued");
		}

		// Set response JSON
		classDTOResp.setClassName(classResult.getClassName());
		classDTOResp.setClassDescription(classResult.getClassDescription());
		classDTOResp.setCreatedAt(classResult.getCreatedAt());

		return classDTOResp;
	}

}
