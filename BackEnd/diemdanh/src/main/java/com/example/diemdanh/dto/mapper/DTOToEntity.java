package com.example.diemdanh.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.diemdanh.dto.DepartmentDTO;
import com.example.diemdanh.dto.FacultyDTO;
import com.example.diemdanh.dto.SubjectDTO;
import com.example.diemdanh.entity.Department;
import com.example.diemdanh.entity.Faculty;
import com.example.diemdanh.entity.Subject;

public class DTOToEntity {
	// * Map SubjectDTO to Subject
	// Input: SubjectDTO dto
	// Output: Subject subject
	// Giang Ngo Truong 10/04/2025
	public static Subject subjectDTOToSubject(SubjectDTO dto) {
	    if (dto == null) return null;

	    Subject subject = new Subject();
	    subject.setSubjectName(dto.getStrSubjectName());
	    subject.setSubjectDescription(dto.getStrSubjectDescription());

	    if (dto.getDepartmentDTO() != null) {
	        subject.setDepartment(departmentDTOToDepartment(dto.getDepartmentDTO()));
	    }

	    return subject;
	}
	
	// * Map DepartmentDTO to Department
	// Input: DepartmentDTO dto
	// Output: Department department
	// Giang Ngo Truong 10/04/2025
	public static Department departmentDTOToDepartment(DepartmentDTO dto) {
		if (dto == null) return null;
		
	    Department department = new Department();
	    department.setDepartmentName(dto.getStrDepartmentName());
	    department.setDepartmentDescription(dto.getStrDepartmentDescription());

	    if (dto.getFacultyDTO() != null) {
	        department.setFaculty(facultyDTOToFaculty(dto.getFacultyDTO()));
	    }

	    // Nếu bạn muốn map lại danh sách Subject → Entity
	    if (dto.getLstSubjectDTO() != null && !dto.getLstSubjectDTO().isEmpty()) {
	        List<Subject> subjectList = new ArrayList<>();
	        for (SubjectDTO subjectDTO : dto.getLstSubjectDTO()) {
	            Subject subject = subjectDTOToSubject(subjectDTO);
	            subject.setDepartment(department); // gán lại mối quan hệ 2 chiều
	            subjectList.add(subject);
	        }
	        department.setSubjects(subjectList);
	    }

	    return department;
	}
	
	// * Map FacultyDTO to Faculty
	// Input: FacultyDTO dto
	// Output: Faculty faculty
	// Giang Ngo Truong 10/04/2025
	public static Faculty facultyDTOToFaculty(FacultyDTO dto) {
		if (dto == null) return null;
		
	    Faculty faculty = new Faculty();
	    faculty.setFacultyName(dto.getStrFacultyName());
	    faculty.setFalcultyDescription(dto.getStrFacultyDescription());
	    return faculty;
	}
}
