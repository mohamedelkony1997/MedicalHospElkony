package com.example.hosp.hosiptal.models.register;

import com.google.gson.annotations.SerializedName;

public class RegisterResponse{

	@SerializedName("data")
	private RegisterData registerData;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public boolean issucess(){
		return status==1;
	}

	public void setData(RegisterData registerData){
		this.registerData = registerData;
	}

	public RegisterData getData(){
		return registerData;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"RegisterResponse{" + 
			"data = '" + registerData + '\'' +
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}