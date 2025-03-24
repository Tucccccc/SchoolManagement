package com.example.diemdanh.service;

import com.example.diemdanh.dto.StudentDTO;

public interface StudentService {
	StudentDTO getAllStudent();
	StudentDTO getStudentByID(Long Id);
}