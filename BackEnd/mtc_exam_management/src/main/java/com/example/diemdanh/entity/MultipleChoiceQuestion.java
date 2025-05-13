package com.example.diemdanh.entity;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PreUpdate;

@Entity
public class MultipleChoiceQuestion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String questionText;
	
	private int difficultyLevel;
	
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MultipleChoiceAnswer> answers;
    
	private LocalDateTime createdAt = LocalDateTime.now();
	private LocalDateTime updatedAt = LocalDateTime.now();
	
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
	
	public MultipleChoiceQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MultipleChoiceQuestion(Long id, String questionText, int diffcultyLevel, List<MultipleChoiceAnswer> answers,
			LocalDateTime createdAt, LocalDateTime updatedAt) {
		super();
		this.id = id;
		this.questionText = questionText;
		this.difficultyLevel = diffcultyLevel;
		this.answers = answers;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}

	public int getDiffcultyLevel() {
		return difficultyLevel;
	}

	public void setDiffcultyLevel(int diffcultyLevel) {
		this.difficultyLevel = diffcultyLevel;
	}

	public List<MultipleChoiceAnswer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<MultipleChoiceAnswer> answers) {
		this.answers = answers;
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