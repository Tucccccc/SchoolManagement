package com.example.diemdanh.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.diemdanh.dto.ExamDTO;
import com.example.diemdanh.entity.Exam;
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

	@Override
	public ExamDTO getExamByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ExamDTO getAllExam() {
		List<Exam> lstExam = examRepository.findAll();
		return Optional.ofNullable(lstExam).filter(list -> !list.isEmpty()).map(list -> {
			ExamDTO examDTO = new ExamDTO();
			examDTO.setIntStatusCode(200);
			examDTO.setLstExam(lstExam);
			examDTO.setStrMsg("Success");
			examDTO.setIsFound(true);
			return examDTO;
		}).orElseGet(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Exam not found");
		});
	}
}