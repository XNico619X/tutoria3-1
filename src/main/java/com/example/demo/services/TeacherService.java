package com.example.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.TeacherModel;
import com.example.demo.repositories.TeacherRepository;


@Service
public class TeacherService {
	
	@Autowired
	TeacherRepository teacherRepository;
	
	public TeacherModel save(TeacherModel teacherModel){
	    return teacherRepository.save(teacherModel);
	
	
	}
	
	public List<TeacherModel> getAll(){
		
		return(List<TeacherModel>) teacherRepository.findAll();
	}
}
