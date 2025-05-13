package com.example.diemdanh.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class ExamQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "exam_id", nullable = false)
    private Exam exam;
    
    @ManyToOne
    @JoinColumn(name = "question_id", nullable = false)
    private MultipleChoiceQuestion question;

	public ExamQuestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ExamQuestion(Long id, Exam exam, MultipleChoiceQuestion question) {
		super();
		this.id = id;
		this.exam = exam;
		this.question = question;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public MultipleChoiceQuestion getQuestion() {
		return question;
	}

	public void setQuestion(MultipleChoiceQuestion question) {
		this.question = question;
	}
}