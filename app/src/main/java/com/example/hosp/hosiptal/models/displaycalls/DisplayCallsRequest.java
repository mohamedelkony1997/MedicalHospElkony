package com.example.hosp.hosiptal.models.displaycalls;

import com.google.gson.annotations.SerializedName;

public class DisplayCallsRequest {
    @SerializedName("date")
    private String date;



    public DisplayCallsRequest( String date) {

        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
