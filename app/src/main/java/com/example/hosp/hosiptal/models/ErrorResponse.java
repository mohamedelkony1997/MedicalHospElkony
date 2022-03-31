package com.example.hosp.hosiptal.models;

import com.google.gson.annotations.SerializedName;

public class ErrorResponse{

	@SerializedName("message")
	private String message;

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	@Override
 	public String toString(){
		return 
			"ErrorResponse{" + 
			"message = '" + message + '\'' + 
			"}";
		}
}