package com.example.hosp.doctor;

public class DoctorsCallsClass {
    String callaname;

    String callsdata;

    public DoctorsCallsClass() {
    }

    public DoctorsCallsClass(String callaname,  String callsdata) {
        this.callaname = callaname;

        this.callsdata = callsdata;
    }
    public String getCallsdata() {
        return callsdata;
    }

    public void setCallsdata(String callsdata) {
        this.callsdata = callsdata;
    }

    public String getCallaname() {
        return callaname;
    }

    public void setCallaname(String callaname) {
        this.callaname = callaname;
    }


}
