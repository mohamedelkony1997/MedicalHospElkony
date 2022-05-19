package com.example.hosp.hosiptal.models.selectdoctors;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class SelectDoctorsResponse{

	@SerializedName("data")
	private List<DataSelectDoctorsItems> data;

	@SerializedName("message")
	private String message;

	@SerializedName("status")
	private int status;

	public void setData(List<DataSelectDoctorsItems> data){
		this.data = data;
	}

	public List<DataSelectDoctorsItems> getData(){
		return data;
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
			"SelectDoctorsResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}