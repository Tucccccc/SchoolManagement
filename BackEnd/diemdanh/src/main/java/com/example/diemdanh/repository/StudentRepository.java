package com.example.diemdanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diemdanh.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
