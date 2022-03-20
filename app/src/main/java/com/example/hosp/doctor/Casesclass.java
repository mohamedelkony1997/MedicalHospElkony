package com.example.hosp.doctor;

public class Casesclass {
    String name;
    String data;


    public Casesclass(String name, String data) {
        name = name;
        data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
