package com.example.hosp.doctor;

public class Nurseclass {
    String Nursename;
    String Nursestatus;


    public Nurseclass(String nursename, String nursestatus) {
        Nursename = nursename;
        Nursestatus = nursestatus;
    }

    public String getNursename() {
        return Nursename;
    }

    public void setNursename(String nursename) {
        Nursename = nursename;
    }

    public String getNursestatus() {
        return Nursestatus;
    }

    public void setNursestatus(String nursestatus) {
        Nursestatus = nursestatus;
    }
}
