package com.example.hosp.hosiptal.models.CreateCall;

import com.google.gson.annotations.SerializedName;

public class CreateCallRequest {
    @SerializedName("patient_name")
    String patient_name;
    @SerializedName("age")
    String age;
    @SerializedName("phone")
    String phone;
    @SerializedName("description")
    String description;
     @SerializedName("doctor_id")
     String doctor_id;

    public CreateCallRequest(String patient_name, String age, String phone, String description, String doctor_id) {
        this.patient_name = patient_name;
        this.age = age;
        this.phone = phone;
        this.description = description;
        this.doctor_id = doctor_id;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(String doctor_id) {
        this.doctor_id = doctor_id;
    }
}
