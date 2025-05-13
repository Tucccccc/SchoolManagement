package com.example.diemdanh.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipleChoiceAnswerDTO {
	private String strAnswerText;
	private Boolean boolIsCorrect;
	private MultipleChoiceQuestionDTO questionDTO;
	
	public MultipleChoiceAnswerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MultipleChoiceAnswerDTO(String strAnswerText, Boolean boolIsCorrect, MultipleChoiceQuestionDTO questionDTO) {
		super();
		this.strAnswerText = strAnswerText;
		this.boolIsCorrect = boolIsCorrect;
		this.questionDTO = questionDTO;
	}

	public String getStrAnswerText() {
		return strAnswerText;
	}

	public void setStrAnswerText(String strAnswerText) {
		this.strAnswerText = strAnswerText;
	}

	public Boolean getBoolIsCorrect() {
		return boolIsCorrect;
	}

	public void setBoolIsCorrect(Boolean boolIsCorrect) {
		this.boolIsCorrect = boolIsCorrect;
	}

	public MultipleChoiceQuestionDTO getQuestionDTO() {
		return questionDTO;
	}

	public void setQuestionDTO(MultipleChoiceQuestionDTO questionDTO) {
		this.questionDTO = questionDTO;
	}
}