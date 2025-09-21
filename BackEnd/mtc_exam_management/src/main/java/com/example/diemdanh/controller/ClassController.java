package com.example.diemdanh.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.diemdanh.dto.ResponseData;
import com.example.diemdanh.dto.request.create.CreateClassRequest;
import com.example.diemdanh.dto.request.update.UpdateClassRequest;
import com.example.diemdanh.dto.response.ClassResponse;
import com.example.diemdanh.service.ClassService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/class")
@Tag(name = "Class Management", description = "APIs for managing Class")
public class ClassController {
    private final ClassService classService;

    public ClassController(ClassService classService) {
        this.classService = classService;
    }
	
	@PostMapping("/v1/admin/add-class")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Add Class", description = "Save Class to Database require ADMIN")
	public ResponseEntity<ResponseData<ClassResponse>> addClass(@Valid @RequestBody CreateClassRequest req) {
		ResponseData<ClassResponse> response = classService.addClass(req);
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}
	
	@GetMapping("/v1/admin/get-all-class")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Get all Class", description = "Get all Class require ADMIN")
	public ResponseEntity<ResponseData<List<ClassResponse>>> getAllClass() {
        ResponseData<List<ClassResponse>> response = classService.getAllClass();
        return ResponseEntity.ok(response);
	}
	
	@PutMapping("/v1/admin/update-class/{classID}")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Update Class", description = "Update Class require ADMIN")
	public ResponseEntity<ResponseData<ClassResponse>> updateClass(@PathVariable Long classID, @RequestBody UpdateClassRequest req) {
		ResponseData<ClassResponse> response = classService.updateClass(classID, req);
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/v1/admin/get-all-class/{classID}")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Get Class by ID", description = "Get Class by ID require ADMIN")
	public ResponseEntity<ResponseData<ClassResponse>> getClassByID(@PathVariable Long classID) {
        ResponseData<ClassResponse> response = classService.getClassById(classID);
        return ResponseEntity.ok(response);
	}
	
	@DeleteMapping("/v1/admin/delete-class-by-id/{classID}")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Delete Class by ID", description = "Delete Class by ID require ADMIN")
	public ResponseEntity<ResponseData<ClassResponse>> deleteClassByID(@PathVariable Long classID) {
        ResponseData<ClassResponse> response = classService.deleteClassById(classID);
        return ResponseEntity.ok(response);
	}
	
    @PostMapping("/v1/admin/assign-students-to-class/{classId}")
	@PreAuthorize("hasRole('ADMIN')")
	@Operation(summary = "Assign Student to Class", description = "Assign Student to Class require ADMIN")
    public ResponseEntity<Map<String, String>> assignStudents(@RequestBody List<Long> lstIdStudent, @PathVariable Long classId) {
    	classService.assignStudentToClass(lstIdStudent, classId);
    	Map<String, String> response = new HashMap<>();
    	response.put("strMsg", "Assign to Class successfully");
        return ResponseEntity.ok(response);
    } 
}