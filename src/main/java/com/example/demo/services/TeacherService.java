package com.example.demo.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.TeacherModel;
import com.example.demo.models.response.ResponseModel;
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
	
	public ResponseModel update(TeacherModel teacherModel) {
		try {
			// validar si el estudiante existe	 
			if(!existTeacher(teacherModel.getId())) {
				return new ResponseModel(false, "Docente no existe");
					}else {
				// como el estudiante existe, entonces vamos a actualizar
				teacherRepository.save(teacherModel);
				return new ResponseModel (true, "Docente Actualizado");
			}	

		}catch (Exception ex) {
			return new ResponseModel(false, ex.toString());
		}
	}

	private boolean existTeacher(int Id) {
		return teacherRepository.findById(Id).isEmpty() ? false : true ;	
		
	}
}