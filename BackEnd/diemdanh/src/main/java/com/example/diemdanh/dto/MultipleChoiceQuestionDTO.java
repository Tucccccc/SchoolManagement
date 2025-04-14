package com.example.diemdanh.dto;

import java.util.List;

import com.example.diemdanh.entity.MultipleChoiceAnswer;
import com.example.diemdanh.entity.MultipleChoiceQuestion;
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
	private List<MultipleChoiceQuestion> lstQuestion;
	private MultipleChoiceQuestion question;
	private String strMsg;
	private Boolean isFound;
	
	public MultipleChoiceQuestionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MultipleChoiceQuestionDTO(int intStatusCode, String strQuestionText, Integer intDifficultyLevel,
			List<MultipleChoiceAnswer> lstAnswer, List<String> lstAnswerText, String strAnswerText,
			List<MultipleChoiceAnswerDTO> lstAnswerDTO, List<MultipleChoiceQuestion> lstQuestion,
			MultipleChoiceQuestion question, String strMsg, Boolean isFound) {
		super();
		this.intStatusCode = intStatusCode;
		this.strQuestionText = strQuestionText;
		this.intDifficultyLevel = intDifficultyLevel;
		this.lstAnswer = lstAnswer;
		this.lstAnswerText = lstAnswerText;
		this.strAnswerText = strAnswerText;
		this.lstAnswerDTO = lstAnswerDTO;
		this.lstQuestion = lstQuestion;
		this.question = question;
		this.strMsg = strMsg;
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

	public List<MultipleChoiceQuestion> getLstQuestion() {
		return lstQuestion;
	}

	public void setLstQuestion(List<MultipleChoiceQuestion> lstQuestion) {
		this.lstQuestion = lstQuestion;
	}

	public String getStrMsg() {
		return strMsg;
	}

	public void setStrMsg(String strMsg) {
		this.strMsg = strMsg;
	}

	public MultipleChoiceQuestion getQuestion() {
		return question;
	}

	public void setQuestion(MultipleChoiceQuestion question) {
		this.question = question;
	}
}