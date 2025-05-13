package com.example.diemdanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.diemdanh.entity.Teacher;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

}
