package com.example.hosp.hosiptal.models.displaycalls;

import java.util.List;

public class DisplayCallsResponse{
	private List<DataItemDisplayCalls> data;
	private String message;
	private int status;
	public boolean issucess(){
		return status==1;
	}
	public void setData(List<DataItemDisplayCalls> data){
		this.data = data;
	}

	public List<DataItemDisplayCalls> getData(){
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
			"DisplayCallsResponse{" + 
			"data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}