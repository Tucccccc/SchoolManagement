package com.example.diemdanh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.diemdanh.dto.ClassDTO;
import com.example.diemdanh.service.ClassService;

@RestController
public class ClassController {
	@Autowired
	private ClassService classService;
	
	@PostMapping("/v1/admin/add-class")
	public ResponseEntity<ClassDTO> addClass(@RequestBody ClassDTO req) {
		ClassDTO classResult = classService.addClass(req);
		return ResponseEntity.status(HttpStatus.CREATED).body(classResult);
	}
	
	@GetMapping("/v1/admin/get-all-class")
	public ResponseEntity<ClassDTO> getAllClass() {
		return ResponseEntity.ok(classService.getAllClass());
	}
	
    @PostMapping("/v1/admin/assign-students-to-class/{classId}")
    public ResponseEntity<Map<String, String>> assignStudents(@RequestBody List<Long> lstIdStudent, @PathVariable Long classId) {
    	classService.assignStudentToClass(lstIdStudent, classId);
    	Map<String, String> response = new HashMap<>();
    	response.put("strMsg", "Assign to Class successfully");
        return ResponseEntity.ok(response);
    } 
}
