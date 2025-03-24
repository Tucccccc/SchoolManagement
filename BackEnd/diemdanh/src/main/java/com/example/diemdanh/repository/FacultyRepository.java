package com.example.diemdanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diemdanh.entity.Faculty;

public interface FacultyRepository extends JpaRepository<Faculty, Long>{}