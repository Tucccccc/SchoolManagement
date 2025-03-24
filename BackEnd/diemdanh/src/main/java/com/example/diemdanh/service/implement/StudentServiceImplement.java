package com.example.diemdanh.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.diemdanh.dto.StudentDTO;
import com.example.diemdanh.entity.Student;
import com.example.diemdanh.repository.StudentRepository;
import com.example.diemdanh.service.StudentService;

@Service
public class StudentServiceImplement implements StudentService{
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public StudentDTO getAllStudent() {
		StudentDTO studentResp = new StudentDTO();
		try {
			List<Student> result = studentRepository.findAll();
			if(!result.isEmpty()) {
				studentResp.setIntStatusCode(200);
				studentResp.setStrMsg("Success");
				studentResp.setLstStudent(result);;
			} else {
				studentResp.setIntStatusCode(404);
				studentResp.setStrMsg("No student found");
			}
			return studentResp;
		}
		catch(Exception e) {
			studentResp.setIntStatusCode(500);
			studentResp.setStrError("An error occurred: " + e.getMessage());
			return studentResp;
		}
	}

	@Override
	public StudentDTO getStudentByID(Long Id) {
		// TODO Auto-generated method stub
		return null;
	}

}
