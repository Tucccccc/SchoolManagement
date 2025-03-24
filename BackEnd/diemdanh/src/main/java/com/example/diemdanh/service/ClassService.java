package com.example.diemdanh.service;

import com.example.diemdanh.dto.ClassDTO;

public interface ClassService {
	ClassDTO addClass(ClassDTO classRequest);
	ClassDTO getAllClass();
	ClassDTO getClassById(Long Id);
}
