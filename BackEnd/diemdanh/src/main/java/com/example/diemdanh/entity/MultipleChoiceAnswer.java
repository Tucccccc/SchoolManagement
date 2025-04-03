package com.example.diemdanh.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PreUpdate;

@Entity
public class MultipleChoiceAnswer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private MultipleChoiceQuestion question;
    
    @Column(nullable = false)
    private String answerText;
    
    @Column(nullable = false)
    private Boolean isCorrect;
    
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();
	
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

	public MultipleChoiceAnswer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MultipleChoiceAnswer(Long id, MultipleChoiceQuestion question, String answerText, Boolean isCorrect,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.question = question;
		this.answerText = answerText;
		this.isCorrect = isCorrect;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public MultipleChoiceQuestion getQuestion() {
		return question;
	}

	public void setQuestion(MultipleChoiceQuestion question) {
		this.question = question;
	}

	public String getAnswerText() {
		return answerText;
	}

	public void setAnswerText(String answerText) {
		this.answerText = answerText;
	}

	public Boolean getIsCorrect() {
		return isCorrect;
	}

	public void setIsCorrect(Boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
}