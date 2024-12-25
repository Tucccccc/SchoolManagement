package com.example.diemdanh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.diemdanh.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}