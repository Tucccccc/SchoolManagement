package com.example.diemdanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.diemdanh.entity.ClassEntity;

@Repository
public interface ClassRepository extends JpaRepository<ClassEntity, Long>{

}
