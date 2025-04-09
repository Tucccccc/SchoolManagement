package com.example.diemdanh.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class MultipleChoiceUserAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "exam_result_id", nullable = false)
    private ExamResult examResult;
    
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private MultipleChoiceQuestion question;
    
    @ManyToOne
    @JoinColumn(name = "selected_answer_id", nullable = false)
    private MultipleChoiceAnswer selectedAnswer;
    
    @Column(nullable = false)
    private boolean isCorrect;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date answeredAt = new Date();

	public MultipleChoiceUserAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MultipleChoiceUserAnswer(Long id, ExamResult examResult, MultipleChoiceQuestion question,
			MultipleChoiceAnswer selectedAnswer, boolean isCorrect, Date answeredAt) {
		super();
		this.id = id;
		this.examResult = examResult;
		this.question = question;
		this.selectedAnswer = selectedAnswer;
		this.isCorrect = isCorrect;
		this.answeredAt = answeredAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ExamResult getExamResult() {
		return examResult;
	}

	public void setExamResult(ExamResult examResult) {
		this.examResult = examResult;
	}

	public MultipleChoiceQuestion getQuestion() {
		return question;
	}

	public void setQuestion(MultipleChoiceQuestion question) {
		this.question = question;
	}

	public MultipleChoiceAnswer getSelectedAnswer() {
		return selectedAnswer;
	}

	public void setSelectedAnswer(MultipleChoiceAnswer selectedAnswer) {
		this.selectedAnswer = selectedAnswer;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public Date getAnsweredAt() {
		return answeredAt;
	}

	public void setAnsweredAt(Date answeredAt) {
		this.answeredAt = answeredAt;
	}
}