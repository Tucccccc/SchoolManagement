package com.example.diemdanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.diemdanh.entity.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {

}
