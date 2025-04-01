package com.example.diemdanh.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diemdanh.dto.StudentDTO;
import com.example.diemdanh.entity.Student;
import com.example.diemdanh.repository.StudentRepository;
import com.example.diemdanh.service.StudentService;

@Service
public class StudentServiceImplement implements StudentService{
	@Autowired
	private StudentRepository studentRepository;

	// * getAllStudent
	// Input:
	// Output: StudentDTO studentResp
	// Giang Ngo Truong 20/03/2025
	@Override
	public StudentDTO getAllStudent() {
		List<Student> lstStudent = studentRepository.findAll();
		
		return Optional.ofNullable(lstStudent)
				.filter(list -> !list.isEmpty())
				.map(list -> {
					StudentDTO studentResp = new StudentDTO();
					studentResp.setIntStatusCode(200);
					studentResp.setStrMsg("Success");
					studentResp.setLstStudent(lstStudent);;
					studentResp.setIsFound(true);
					return studentResp;
				})
				.orElseGet(() -> {
					StudentDTO studentResp = new StudentDTO();
					studentResp.setIntStatusCode(404);
					studentResp.setStrMsg("Student list is empty");
					studentResp.setIsFound(false);
					return studentResp;
				});
	}

	// * getStudentByID
	// Input: Id
	// Output: StudentDTO studentResp
	// Giang Ngo Truong 24/03/2025
	@Override
	public StudentDTO getStudentByID(Long Id) {
		return studentRepository.findById(Id)
				.map(student -> {
					StudentDTO studentResp = new StudentDTO();
					studentResp.setStudent(student);
					studentResp.setIntStatusCode(200);
					studentResp.setStrMsg("Student with ID: " + Id + " found Successfully!");
					studentResp.setIsFound(true);
					return studentResp;
				})
				.orElseGet(() -> {
					StudentDTO studentResp = new StudentDTO();
					studentResp.setIntStatusCode(404);
					studentResp.setStrError("Student not found");
					studentResp.setIsFound(false);
					return studentResp;
				});
	}

	// * getStudentWithoutClass
	// Input: 
	// Output: StudentDTO lstStudent
	// Giang Ngo Truong 01/04/2025
	@Transactional(readOnly = true)
	@Override
	public StudentDTO getStudentWithoutClass() {
		List<Student> lstStudent = studentRepository.findStudentWithoutClass();
		return Optional.ofNullable(lstStudent)
				.filter(list -> !list.isEmpty())
				.map(list -> {
					StudentDTO studentDTO = new StudentDTO();
					studentDTO.setIntStatusCode(200);
					studentDTO.setLstStudent(lstStudent);
					studentDTO.setIsFound(true);
					return studentDTO;
				})
				.orElseGet(() -> {
					StudentDTO studentDTO = new StudentDTO();
					studentDTO.setIntStatusCode(404);
					studentDTO.setStrMsg("No student found");
					studentDTO.setIsFound(false);
					return studentDTO;
				});
	}
}