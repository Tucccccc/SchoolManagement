package com.example.diemdanh.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diemdanh.dto.MultipleChoiceAnswerDTO;
import com.example.diemdanh.dto.MultipleChoiceQuestionDTO;
import com.example.diemdanh.dto.mapper.EntityToDTO;
import com.example.diemdanh.entity.MultipleChoiceAnswer;
import com.example.diemdanh.entity.MultipleChoiceQuestion;
import com.example.diemdanh.exception.types.InternalServerException;
import com.example.diemdanh.exception.types.ResourceNotFoundException;
import com.example.diemdanh.global.common.CommonMethods;
import com.example.diemdanh.repository.MultipleChoiceAnswerRepository;
import com.example.diemdanh.repository.MultipleChoiceQuestionRepository;
import com.example.diemdanh.service.MultipleChoiceQuestionService;

@Service
public class MultipleChoiceQuestionServiceImplement implements MultipleChoiceQuestionService {
	@Autowired
	private MultipleChoiceQuestionRepository multipleChoiceQuestionRepository;
	@Autowired
	private MultipleChoiceAnswerRepository multipleChoiceAnswerRepository;

	private CommonMethods common = new CommonMethods();

	// * Add Question
	// Input: MultipleChoiceQuestionDTO multipleChoiceQuestionRequest
	// Output: MultipleChoiceQuestionDTO multipleChoiceQuestionDTO
	// Add question within answer
	// Giang Ngo Truong 17/03/2025
	@Transactional(rollbackFor = Exception.class)
	@Override
	public MultipleChoiceQuestionDTO addQuestion(MultipleChoiceQuestionDTO multipleChoiceQuestionRequest) {
		// Save Question to get question ID
		MultipleChoiceQuestion multipleChoiceQuestion = multipleChoiceQuestionRepository
				.save(common.createMultipleChoiceQuestionWithoutAnswer(multipleChoiceQuestionRequest));
		
		if(multipleChoiceQuestion == null || multipleChoiceQuestion.getId() == null) {
			throw new InternalServerException("Multiple Choice Question save failed");
		}

		// List of answer
		List<MultipleChoiceAnswer> lstAnswer = new ArrayList<>();
		for (MultipleChoiceAnswerDTO answerDTO : multipleChoiceQuestionRequest.getLstAnswerDTO()) {
			MultipleChoiceAnswer multipleChoiceAnswer = new MultipleChoiceAnswer();
			multipleChoiceAnswer.setAnswerText(answerDTO.getStrAnswerText());
			multipleChoiceAnswer.setQuestion(multipleChoiceQuestion);
			multipleChoiceAnswer.setIsCorrect(answerDTO.getBoolIsCorrect());
			lstAnswer.add(multipleChoiceAnswer);
		}

		List<MultipleChoiceAnswer> lstAnswerResult = multipleChoiceAnswerRepository.saveAll(lstAnswer);
		
		if(lstAnswerResult.isEmpty()) {
			throw new InternalServerException("List Answer save failed");
		}
		
		// Add list answer to saved question
		multipleChoiceQuestion.setAnswers(lstAnswer);

		// Return value
		MultipleChoiceQuestionDTO multipleChoiceQuestionDTOReturn = new MultipleChoiceQuestionDTO();
		multipleChoiceQuestionDTOReturn.setIntStatusCode(200);
		multipleChoiceQuestionDTOReturn.setStrQuestionText(multipleChoiceQuestion.getQuestionText());
		multipleChoiceQuestionDTOReturn.setIntDifficultyLevel(multipleChoiceQuestion.getDiffcultyLevel());
		multipleChoiceQuestionDTOReturn.setLstAnswerDTO(
				lstAnswer.stream().map(EntityToDTO::answerToAnswerDTO).collect(Collectors.toList()));

		return multipleChoiceQuestionDTOReturn;
	}

	// * Get Question by ID
	// Input: Long id
	// Output: MultipleChoiceQuestionDTO multipleChoiceQuestionDTO
	// Giang Ngo Truong 14/04/2025
	@Transactional(readOnly = true)
	@Override
	public MultipleChoiceQuestionDTO getMTCQuestionByID(Long id) {
		return multipleChoiceQuestionRepository.findById(id).map(multipleChoiceQuestion -> {
			MultipleChoiceQuestionDTO multipleChoiceQuestionDTOReturn = new MultipleChoiceQuestionDTO();
			multipleChoiceQuestionDTOReturn.setIntStatusCode(200);
			multipleChoiceQuestionDTOReturn.setStrMsg("Success");
			multipleChoiceQuestionDTOReturn.setQuestion(multipleChoiceQuestion);
			multipleChoiceQuestionDTOReturn.setIsFound(true);
			return multipleChoiceQuestionDTOReturn;
		}).orElseGet(() -> {
			throw new ResourceNotFoundException("MTC Question", "ID", id.toString());
		});
	}

	// * Get All Question by ID
	// Input: List<Long> lstId
	// Output: MultipleChoiceQuestionDTO lstMultipleChoiceQuestionDTO
	// Giang Ngo Truong 15/04/2025
	@Transactional(readOnly = true)
	@Override
	public MultipleChoiceQuestionDTO getAllMTCQuestionByID(List<Long> lstId) {
		List<MultipleChoiceQuestion> lstMultipleChoiceQuestions = new ArrayList<MultipleChoiceQuestion>();
		MultipleChoiceQuestionDTO multipleChoiceQuestionDTOReturn = new MultipleChoiceQuestionDTO();
		lstMultipleChoiceQuestions = multipleChoiceQuestionRepository.findAllById(lstId);
		
		if(lstMultipleChoiceQuestions.isEmpty()) {
			throw new ResourceNotFoundException("MTC Questions not found");
		} else {
			multipleChoiceQuestionDTOReturn.setIntStatusCode(200);
			multipleChoiceQuestionDTOReturn.setIsFound(true);
			multipleChoiceQuestionDTOReturn.setLstQuestion(lstMultipleChoiceQuestions);
			multipleChoiceQuestionDTOReturn.setStrMsg("Success");
		}
		
		return multipleChoiceQuestionDTOReturn;
	}

	// * Get All Question
	// Input: 
	// Output: MultipleChoiceQuestionDTO lstMultipleChoiceQuestionDTO
	// Giang Ngo Truong 15/04/2025
	@Transactional(readOnly = true)
	@Override
	public MultipleChoiceQuestionDTO getAllMTCQuestion() {
		List<MultipleChoiceQuestion> lstMTCQuestion = multipleChoiceQuestionRepository.findAll();
		
		return Optional.ofNullable(lstMTCQuestion).filter(list -> !list.isEmpty()).map(list -> {
			MultipleChoiceQuestionDTO multipleChoiceQuestionDTOReturn = new MultipleChoiceQuestionDTO();
			multipleChoiceQuestionDTOReturn.setIntStatusCode(200);
			multipleChoiceQuestionDTOReturn.setStrMsg("Success");
			multipleChoiceQuestionDTOReturn.setLstQuestion(lstMTCQuestion);
			multipleChoiceQuestionDTOReturn.setIsFound(true);
			return multipleChoiceQuestionDTOReturn;
		}).orElseGet(() -> {
			throw new ResourceNotFoundException("MTC Questions not found");
		});
	}
}