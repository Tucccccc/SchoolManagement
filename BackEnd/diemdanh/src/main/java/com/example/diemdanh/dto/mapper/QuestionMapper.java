package com.example.diemdanh.dto.mapper;

import com.example.diemdanh.dto.MultipleChoiceAnswerDTO;
import com.example.diemdanh.entity.MultipleChoiceAnswer;

public class QuestionMapper {
	// * Mapp Answer to AnswerDTO
	// Input: MultipleChoiceAnswer answer
	// Output: MultipleChoiceAnswerDTO dto
	// Giang Ngo Truong 17/03/2025
    public static MultipleChoiceAnswerDTO answerToAnswerDTO(MultipleChoiceAnswer answer) {
        MultipleChoiceAnswerDTO dto = new MultipleChoiceAnswerDTO();
        dto.setStrAnswerText(answer.getAnswerText());
        dto.setBoolIsCorrect(answer.getIsCorrect());
        return dto;
    }
}