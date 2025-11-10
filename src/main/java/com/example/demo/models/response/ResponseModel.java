package com.example.demo.models.response;

public class ResponseModel {

	private boolean Succesfully;
	private String Message;
	
	
	public ResponseModel(boolean succesfully, String message) {
		Succesfully = succesfully;
		Message = message;
	}
	
	public boolean isSuccesfully() {
		return Succesfully;
	}
	public void setSuccesfully(boolean succesfully) {
		Succesfully = succesfully;
	}
	public String getMessage() {
		return Message;
	}
	public void setMessage(String message) {
		Message = message;
	}
	
	
	
	
	
}