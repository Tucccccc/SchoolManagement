package com.example.diemdanh.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import com.example.diemdanh.dto.DepartmentDTO;
import com.example.diemdanh.dto.FacultyDTO;
import com.example.diemdanh.dto.MultipleChoiceAnswerDTO;
import com.example.diemdanh.dto.SubjectDTO;
import com.example.diemdanh.entity.Department;
import com.example.diemdanh.entity.Faculty;
import com.example.diemdanh.entity.MultipleChoiceAnswer;
import com.example.diemdanh.entity.Subject;

public class EntityToDTO {
	// * Map Answer to AnswerDTO
	// Input: MultipleChoiceAnswer answer
	// Output: MultipleChoiceAnswerDTO dto
	// Giang Ngo Truong 17/03/2025
    public static MultipleChoiceAnswerDTO answerToAnswerDTO(MultipleChoiceAnswer answer) {
    	if (answer == null) return null;
    	
        MultipleChoiceAnswerDTO dto = new MultipleChoiceAnswerDTO();
        dto.setStrAnswerText(answer.getAnswerText());
        dto.setBoolIsCorrect(answer.getIsCorrect());
        return dto;
    }
    
	// * Map Subject to SubjectDTO
	// Input: Subject subject
	// Output: SubjectDTO dto
	// Giang Ngo Truong 09/04/2025
    public static SubjectDTO subjectToSubjectDTO(Subject subject) {
    	if (subject == null) return null;
    	
        SubjectDTO dto = new SubjectDTO();
        dto.setStrSubjectName(subject.getSubjectName());
        dto.setStrSubjectDescription(subject.getSubjectDescription());
        
        if(subject.getDepartment() != null) {
            // Only map what is needed to avoid infinite loop
            Department dept = subject.getDepartment();
            DepartmentDTO deptDTO = new DepartmentDTO();
            deptDTO.setStrDepartmentName(dept.getDepartmentName());
            deptDTO.setStrDepartmentDescription(dept.getDepartmentDescription());
            
            if (dept.getFaculty() != null) {
                deptDTO.setFacultyDTO(facultyToFacultyDTO(dept.getFaculty()));
            }
            
            dto.setDepartmentDTO(deptDTO);
        }
        return dto;
    }
    
	// * Map Department to DepartmentDTO
	// Input: Department department
	// Output: DepartmentDTO dto
	// Giang Ngo Truong 09/04/2025
    public static DepartmentDTO departmentToDepartmentDTO(Department department) {
    	if (department == null) return null;
    	
    	DepartmentDTO dto = new DepartmentDTO();
    	dto.setStrDepartmentName(department.getDepartmentName());
    	dto.setStrDepartmentDescription(department.getDepartmentDescription());
    	if(department.getFaculty() != null) {
    		dto.setFacultyDTO(facultyToFacultyDTO(department.getFaculty()));
    	}
    	if(!department.getSubjects().isEmpty() && department.getSubjects() != null) {
            List<SubjectDTO> subjectDTOList = new ArrayList<>();
            for (Subject subject : department.getSubjects()) {
            	// Need to set without Department to prevent infinite loop
                subjectDTOList.add(subjectToSubjectDTOWithoutDepartment(subject));
            }
            dto.setLstSubjectDTO(subjectDTOList);
    	}
    	return dto;
    }
    
	// * Map Faculty to FacultyDTO
	// Input: Faculty faculty
	// Output: FacultyDTO dto
	// Giang Ngo Truong 09/04/2025
    public static FacultyDTO facultyToFacultyDTO(Faculty faculty) {
    	if (faculty == null) return null;
    	
    	FacultyDTO dto = new FacultyDTO();
    	dto.setStrFacultyName(faculty.getFacultyName());
    	dto.setStrFacultyDescription(faculty.getFalcultyDescription());
    	
    	return dto;
    }
    
	// * Map Subject to SubjectDTO without Department
	// Input: Subject subject
	// Output: SubjectDTO dto
	// Giang Ngo Truong 10/04/2025
    private static SubjectDTO subjectToSubjectDTOWithoutDepartment(Subject subject) {
    	if (subject == null) return null;
    	
        SubjectDTO dto = new SubjectDTO();
        dto.setStrSubjectName(subject.getSubjectName());
        dto.setStrSubjectDescription(subject.getSubjectDescription());

        return dto;
    }
}