package com.example.demo.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.models.StudentModel;
import com.example.demo.models.response.ResponseModel;
import com.example.demo.services.StudentService;

@RestController 
@RequestMapping ("/student")
public class StudentController {
	@Autowired
	StudentService studentService;
 	
	@GetMapping
	public ResponseEntity<List<StudentModel>> getAll(){
		return ResponseEntity.ok(studentService.getAll());
	}
		
	@PostMapping 
	public ResponseEntity<StudentModel> 
		   save(@RequestBody StudentModel studentModel){
		return ResponseEntity.ok(studentService.save(studentModel));
	}
	
	@PutMapping
	public ResponseEntity<ResponseModel> 
	   update(@RequestBody StudentModel studentModel){
	return ResponseEntity.ok(studentService.update(studentModel));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseModel> 
	   delete (@PathVariable("id") int id){
	return ResponseEntity.ok(studentService.deleteStudent(id));
	}

}