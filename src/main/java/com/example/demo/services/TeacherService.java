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
	
	public ResponseModel save(TeacherModel teacherModel) {
	    try {
	        List<TeacherModel> docentes = (List<TeacherModel>) teacherRepository.findAll();

	        boolean existeDuplicado = docentes.stream().anyMatch(d ->
	        d.getDocumentNumber() == teacherModel.getDocumentNumber()||
	        d.getDocumentTypeId() == teacherModel.getDocumentTypeId() 
	            
	        );

	        if (existeDuplicado) {
	            return new ResponseModel(false, "Ya existe un docente con el mismo documento o cédula");
	        }

	        teacherRepository.save(teacherModel);
	        return new ResponseModel(true, "Docente guardado correctamente");

	    } catch (Exception ex) {
	        return new ResponseModel(false, ex.getMessage());
	    }
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
	
public ResponseModel deleteTeacher (int Id) {
		
		try {
			
			if(!existTeacher(Id)) {
				return new ResponseModel (false,"Docente no existe");
			}else {
				teacherRepository.deleteById(Id);
				return new ResponseModel (true,"Docente eliminado");
			}

		}catch (Exception ex){
			return new ResponseModel (false,ex.getMessage());
		}

	}

	private boolean existTeacher(int Id) {
		return teacherRepository.findById(Id).isEmpty() ? false : true ;	
		
	}
}