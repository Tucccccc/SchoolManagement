package com.example.diemdanh.global.common;

import com.example.diemdanh.dto.ClassDTO;
import com.example.diemdanh.dto.FacultyDTO;
import com.example.diemdanh.dto.UserDTO;
import com.example.diemdanh.entity.ClassEntity;
import com.example.diemdanh.entity.Faculty;
import com.example.diemdanh.entity.Student;
import com.example.diemdanh.entity.Teacher;
import com.example.diemdanh.entity.User;

public class CommonMethods {
	// * Create new Teacher
	// Input: UserDTO registrationRequest, String strRole, String strPassword
	// Output: User user
	// Giang Ngo Truong 04/03/2025
	public Teacher createTeacher(User userResult, UserDTO registrationRequest) {
		Teacher teacher = new Teacher();
		teacher.setUser(userResult);
		teacher.setTeacherCode("GV" + userResult.getId());
		teacher.setDegree(registrationRequest.getStrDegree());
		teacher.setCoopType(registrationRequest.getStrCoopType());
		teacher.setDepartment(registrationRequest.getDepartment());
		teacher.setSpecialization(registrationRequest.getStrSprecialization());
		
		return teacher;
	}
	
	// * Create new Student
	// Input: User userResult, UserDTO registrationRequest
	// Output: Student student
	// Giang Ngo Truong 03/03/2025
	public Student createStudent(User userResult, UserDTO registrationRequest) {
		Student student = new Student();
		student.setUser(userResult);
		student.setStudentCode("HS" + registrationRequest.getIntStudentYearOfAdmission() + userResult.getId());
		student.setMothersName(registrationRequest.getStrStudentMothersName());
		student.setMothersDateOfBirth(registrationRequest.getDateStudentFathersDateOfBirth());
		student.setMothersPhoneNumber(registrationRequest.getStrStudentMothersPhoneNumbers());
		student.setMothersProfession(registrationRequest.getStrStudentMothersProfession());
		student.setFathersName(registrationRequest.getStrStudentFathersName());
		student.setFathersDateOfBirth(registrationRequest.getDateStudentFathersDateOfBirth());
		student.setFathersPhoneNumber(registrationRequest.getStrStudentFathersPhoneNumber());
		student.setFathersProfession(registrationRequest.getStrStudentFathersProfession());
		student.setIntYearOfAdmission(registrationRequest.getIntStudentYearOfAdmission() != null
				? registrationRequest.getIntStudentYearOfAdmission()
				: 0);

		return student;
	}
	
	// * Create new User
	// Input: UserDTO registrationRequest, String strRole, String strPassword
	// Output: User user
	// Giang Ngo Truong 03/03/2025
	public User createUser(UserDTO registrationRequest, String strRole, String strPassword) {
		User user = new User();
		user.setUsername(registrationRequest.getStrUsername());
		user.setIdentityNumber(registrationRequest.getStrIdentityNumber());
		user.setPassword(strPassword);
		user.setGender(registrationRequest.getStrGender());
		user.setPhoneNumber(registrationRequest.getStrPhoneNumber());
		user.setEnabled(true);
		user.setFullName(registrationRequest.getStrFullName());
		user.setCity(registrationRequest.getStrCity());
		user.setFullName(registrationRequest.getStrPernamentAddress());
		user.setContactAddress(registrationRequest.getStrContactAddress());
		user.setEthnic(registrationRequest.getStrEthnic());
		user.setReligion(registrationRequest.getStrReligion());
		user.setNationality(registrationRequest.getStrNationality());
		user.setDateOfBirth(registrationRequest.getDateOfBirth());
		user.setRole(strRole);

		return user;
	}
	
	// * createClass
	// Input: ClassDTO classDTO
	// Output: ClassEntity classEntity
	// Giang Ngo Truong 20/03/2025
	public ClassEntity createClass(ClassDTO classDTO) {
		ClassEntity classEntity = new ClassEntity();
		classEntity.setClassName(classDTO.getStrClassName());
		classEntity.setClassDescription(classDTO.getStrClassDescription());
		
		return classEntity;
	}
	
	// * createFaculty
	// Input: FacultyDTO facultyDTO
	// Output: Faculty faculty
	// Giang Ngo Truong 24/03/2025
	public Faculty createFaculty(FacultyDTO facultyDTO) {
		Faculty faculty = new Faculty();
		faculty.setFacultyName(facultyDTO.getStrFacultyName());
		faculty.setFalcultyDescription(facultyDTO.getStrFacultyDescription());
		
		return faculty;
	}
}