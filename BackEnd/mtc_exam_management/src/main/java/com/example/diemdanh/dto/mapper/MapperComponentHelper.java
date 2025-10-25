package com.example.diemdanh.dto.mapper;

import org.springframework.stereotype.Component;

import com.example.diemdanh.dto.response.ClassResponse;
import com.example.diemdanh.dto.response.FacultyResponse;
import com.example.diemdanh.entity.ClassEntity;
import com.example.diemdanh.entity.Faculty;

// * Mapper Component Helper
// * Giang Ngo Truong 18/09/2025
@Component
public class MapperComponentHelper {
	// * convertToDTO
	// Input: ClassEntity entity
	// Output: ClassResponse dto
	// Giang Ngo Truong 18/09/2025
	public ClassResponse convertClassToDTO(ClassEntity entity) {
    	ClassResponse dto = new ClassResponse();
        dto.setId(entity.getId());
        dto.setClassName(entity.getClassName());
        dto.setClassDescription(entity.getClassDescription());
        dto.setStatus(entity.getStatus());

        dto.setCreatedAt(entity.getCreatedAt());
        dto.setUpdatedAt(entity.getUpdatedAt());
        return dto;
    }
	
	// * convertToDTO
	// Input: Faculty entity
	// Output: FacultyResponse dto
	// Giang Ngo Truong 23/10/2025
	public FacultyResponse convertFacultyToDTO(Faculty faculty) {
		FacultyResponse dto = new FacultyResponse();
		dto.setId(faculty.getId());
		dto.setFacultyName(faculty.getFacultyName());
		dto.setFacultyDescription(faculty.getFalcultyDescription());
		dto.setStatus(faculty.getStatus());
		
		dto.setCreatedAt(faculty.getCreatedAt());
		dto.setUpdatedAt(faculty.getUpdatedAt());
		return dto;
	}
}
