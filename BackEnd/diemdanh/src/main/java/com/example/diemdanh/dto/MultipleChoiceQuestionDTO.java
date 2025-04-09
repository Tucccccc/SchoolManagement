package com.example.diemdanh.dto;

import java.util.List;

import com.example.diemdanh.entity.MultipleChoiceAnswer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class MultipleChoiceQuestionDTO {
	private int intStatusCode;
	private String strQuestionText;
	private Integer intDifficultyLevel;
	private List<MultipleChoiceAnswer> lstAnswer;
	private List<String> lstAnswerText;
	private String strAnswerText;
	private List<MultipleChoiceAnswerDTO> lstAnswerDTO;
	private Boolean isFound;
	
	public MultipleChoiceQuestionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MultipleChoiceQuestionDTO(int intStatusCode, String strQuestionText, Integer intDifficultyLevel,
			List<MultipleChoiceAnswer> lstAnswer, List<String> lstAnswerText, String strAnswerText,
			List<MultipleChoiceAnswerDTO> lstAnswerDTO, Boolean isFound) {
		super();
		this.intStatusCode = intStatusCode;
		this.strQuestionText = strQuestionText;
		this.intDifficultyLevel = intDifficultyLevel;
		this.lstAnswer = lstAnswer;
		this.lstAnswerText = lstAnswerText;
		this.strAnswerText = strAnswerText;
		this.lstAnswerDTO = lstAnswerDTO;
		this.isFound = isFound;
	}

	public String getStrQuestionText() {
		return strQuestionText;
	}

	public void setStrQuestionText(String strQuestionText) {
		this.strQuestionText = strQuestionText;
	}

	public Integer getIntDifficultyLevel() {
		return intDifficultyLevel;
	}

	public void setIntDifficultyLevel(Integer intDifficultyLevel) {
		this.intDifficultyLevel = intDifficultyLevel;
	}

	public List<MultipleChoiceAnswer> getLstAnswer() {
		return lstAnswer;
	}

	public void setLstAnswer(List<MultipleChoiceAnswer> lstAnswer) {
		this.lstAnswer = lstAnswer;
	}

	public String getStrAnswerText() {
		return strAnswerText;
	}

	public void setStrAnswerText(String strAnswerText) {
		this.strAnswerText = strAnswerText;
	}

	public List<String> getLstAnswerText() {
		return lstAnswerText;
	}

	public void setLstAnswerText(List<String> lstAnswerText) {
		this.lstAnswerText = lstAnswerText;
	}

	public List<MultipleChoiceAnswerDTO> getLstAnswerDTO() {
		return lstAnswerDTO;
	}

	public void setLstAnswerDTO(List<MultipleChoiceAnswerDTO> lstAnswerDTO) {
		this.lstAnswerDTO = lstAnswerDTO;
	}

	public int getIntStatusCode() {
		return intStatusCode;
	}

	public void setIntStatusCode(int intStatusCode) {
		this.intStatusCode = intStatusCode;
	}

	public Boolean getIsFound() {
		return isFound;
	}

	public void setIsFound(Boolean isFound) {
		this.isFound = isFound;
	}
}