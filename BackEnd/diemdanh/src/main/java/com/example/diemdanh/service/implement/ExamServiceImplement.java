package com.example.diemdanh.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diemdanh.dto.ExamDTO;
import com.example.diemdanh.repository.ExamRepository;
import com.example.diemdanh.service.ExamService;

@Service
public class ExamServiceImplement implements ExamService {
	@Autowired
	private ExamRepository examRepository;

	@Override
	public ExamDTO addExam(ExamDTO examRequest) {
		// TODO Auto-generated method stub
		return null;
	}
}