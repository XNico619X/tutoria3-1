package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.example.demo.models.StudentModel;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel, Integer> {
	
	// consultas personalizadas

}