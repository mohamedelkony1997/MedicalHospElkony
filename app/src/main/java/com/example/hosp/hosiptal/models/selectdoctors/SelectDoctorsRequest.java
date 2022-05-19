package com.example.hosp.hosiptal.models.selectdoctors;

import com.google.gson.annotations.SerializedName;

public class SelectDoctorsRequest {
    @SerializedName("type")
    String type;

    public SelectDoctorsRequest(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
