package com.example.diemdanh.service.implement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.diemdanh.dto.MultipleChoiceAnswerDTO;
import com.example.diemdanh.dto.MultipleChoiceQuestionDTO;
import com.example.diemdanh.dto.mapper.QuestionMapper;
import com.example.diemdanh.entity.MultipleChoiceAnswer;
import com.example.diemdanh.entity.MultipleChoiceQuestion;
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
	// Giang Ngo Truong 17/03/2025
	@Transactional(rollbackFor = Exception.class)
	@Override
	public MultipleChoiceQuestionDTO addQuestion(MultipleChoiceQuestionDTO multipleChoiceQuestionRequest) {
		// Save Question to get question ID
		MultipleChoiceQuestion multipleChoiceQuestion = multipleChoiceQuestionRepository
				.save(common.createMultipleChoiceQuestionWithoutAnswer(multipleChoiceQuestionRequest));

		// List of answer
		List<MultipleChoiceAnswer> lstAnswer = new ArrayList<>();
		for (MultipleChoiceAnswerDTO answerDTO : multipleChoiceQuestionRequest.getLstAnswerDTO()) {
			MultipleChoiceAnswer multipleChoiceAnswer = new MultipleChoiceAnswer();
			multipleChoiceAnswer.setAnswerText(answerDTO.getStrAnswerText());
			multipleChoiceAnswer.setQuestion(multipleChoiceQuestion);
			multipleChoiceAnswer.setIsCorrect(answerDTO.getBoolIsCorrect());
			lstAnswer.add(multipleChoiceAnswer);
		}

		multipleChoiceAnswerRepository.saveAll(lstAnswer);
		// Add list answer to saved question
		multipleChoiceQuestion.setAnswers(lstAnswer);

		// Return value
		MultipleChoiceQuestionDTO multipleChoiceQuestionDTOReturn = new MultipleChoiceQuestionDTO();
		multipleChoiceQuestionDTOReturn.setIntStatusCode(200);
		multipleChoiceQuestionDTOReturn.setStrQuestionText(multipleChoiceQuestion.getQuestionText());
		multipleChoiceQuestionDTOReturn.setIntDifficultyLevel(multipleChoiceQuestion.getDiffcultyLevel());
		multipleChoiceQuestionDTOReturn.setLstAnswerDTO(
				lstAnswer.stream().map(QuestionMapper::answerToAnswerDTO).collect(Collectors.toList()));

		return multipleChoiceQuestionDTOReturn;
	}
}