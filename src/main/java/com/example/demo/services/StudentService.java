package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.models.StudentModel;
import com.example.demo.models.response.ResponseModel;
import com.example.demo.repositories.StudentRepository;

@Service
public class StudentService {
	@Autowired 
	StudentRepository studentRepository;
	
	public StudentModel save (StudentModel studentModel) {		
		// hacer validación previa 
		return studentRepository.save(studentModel); 
	}
	
	public List<StudentModel> getAll(){
		return(List <StudentModel>) studentRepository.findAll();

	}
	
	public ResponseModel update (StudentModel studentModel) {
		try {
			// validar si el estudiante existe	 
			if(!existeEstudiante(studentModel.getId())) {
				return new ResponseModel(false, "Estudiante no existe");
					}else {
				// como el estudiante existe, entonces vamos a actualizar
				studentRepository.save(studentModel);
				return new ResponseModel (true, "Estudiante Actualizado");
			}	

		}catch (Exception ex) {
			return new ResponseModel(false, ex.toString());
		}
	}
	
	public ResponseModel deleteStudent (int Id) {
		
		try {
			
			if(!existeEstudiante(Id)) {
				return new ResponseModel (false,"Estudiante no existe");
			}else {
				studentRepository.deleteById(Id);
				return new ResponseModel (true,"Estudiante eliminado");
			}

		}catch (Exception ex){
			return new ResponseModel (false,ex.getMessage());
		}

	}
	
	private boolean existeEstudiante(int Id) {
		return studentRepository.findById(Id).isEmpty() ? false : true ;	
		
	}
}