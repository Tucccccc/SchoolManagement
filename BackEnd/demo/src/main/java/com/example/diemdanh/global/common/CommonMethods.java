package com.example.diemdanh.global.common;

import com.example.demo.dto.request.ClassRequest;
import com.example.demo.entity.ClassEntity;

public class CommonMethods {
	// * createClass
	// Input: ClassDTO classDTO
	// Output: ClassEntity classEntity
	// Giang Ngo Truong 20/03/2025
	public ClassEntity createClass(ClassRequest classDTO) {
		ClassEntity classEntity = new ClassEntity();
		classEntity.setClassName(classDTO.getStrClassName());
		classEntity.setClassDescription(classDTO.getStrClassDescription());
		
		return classEntity;
	}
}