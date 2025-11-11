package com.example.demo.repositories;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.TeacherModel;

public interface TeacherRepository extends CrudRepository<TeacherModel, Integer>{

}
