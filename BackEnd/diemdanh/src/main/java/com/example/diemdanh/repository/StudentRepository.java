package com.example.diemdanh.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.diemdanh.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	@Query("SELECT s FROM Student s WHERE s.homeRoomClass IS NULL")
	List<Student> findStudentWithoutClass();
}