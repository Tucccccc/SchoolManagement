package com.example.diemdanh.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diemdanh.dto.SubjectDTO;
import com.example.diemdanh.entity.Subject;
import com.example.diemdanh.global.common.CommonMethods;
import com.example.diemdanh.repository.SubjectRepository;
import com.example.diemdanh.service.SubjectService;

@Service
public class SubjectServiceImplement implements SubjectService{
	@Autowired
	private SubjectRepository subjectRepository;
	
	private CommonMethods common = new CommonMethods();

	// * Add Subject
	// Input: SubjectDTO subjectRequest
	// Output: SubjectDTO subjectDTO
	// Giang Ngo Truong 10/04/2025
	@Transactional(rollbackFor = Exception.class)
	@Override
	public SubjectDTO addSubject(SubjectDTO subjectRequest) {
		SubjectDTO subjectDTO = new SubjectDTO();
		
		Subject subject = common.createSubject(subjectRequest);
		
		Subject subjectResult = subjectRepository.save(subject);
		
		if(subjectResult == null || subjectResult.getId() == null) {
			throw new IllegalStateException("Subject save fail");
		}
		
		subjectDTO.setIntStatusCode(200);
		subjectDTO.setStrMsg("Subject saved successfully");
		subjectDTO.setSubject(subjectResult);
		
		return subjectDTO;
	}
}