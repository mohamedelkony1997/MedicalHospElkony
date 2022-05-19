package com.example.hosp.hosiptal.models.displaycalls;

import com.google.gson.annotations.SerializedName;

public class DataItemDisplayCalls {
    @SerializedName("patient_name")
	private String patientName;
    @SerializedName("created_at")
	private String createdAt;
	@SerializedName("id")
	private int id;
	@SerializedName("status")
	private String status;

	public void setPatientName(String patientName){
		this.patientName = patientName;
	}

	public String getPatientName(){
		return patientName;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"DataItemDisplayCalls{" +
			"patient_name = '" + patientName + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}
