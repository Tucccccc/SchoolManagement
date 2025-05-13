package com.example.diemdanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.diemdanh.entity.Faculty;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Long>{}