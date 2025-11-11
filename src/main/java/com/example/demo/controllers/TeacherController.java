package com.example.demo.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.TeacherModel;
import com.example.demo.models.response.ResponseModel;
import com.example.demo.services.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	@Autowired
	
	TeacherService teacherService;
	
	@GetMapping
	public ResponseEntity<List<TeacherModel>> getAll(){
		return ResponseEntity.ok(teacherService.getAll());
	}
	
	@PostMapping
	public ResponseEntity<TeacherModel> 
	       save(@RequestBody TeacherModel teacherModel){
		return ResponseEntity.ok(teacherService.save(teacherModel));
	}
	
	@PutMapping
	public ResponseEntity<ResponseModel> 
    	update(@RequestBody TeacherModel teacherModel){
	return ResponseEntity.ok(teacherService.update(teacherModel));
}

}
