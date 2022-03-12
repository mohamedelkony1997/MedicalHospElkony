package com.example.hosp;

public class CallsClass {
    String callaname;
    String callsstatus;
    String callsdata;

    public CallsClass() {
    }

    public CallsClass(String callaname, String callsstatus, String callsdata) {
        this.callaname = callaname;
        this.callsstatus = callsstatus;
        this.callsdata = callsdata;
    }

    public String getCallsstatus() {
        return callsstatus;
    }

    public void setCallsstatus(String callsstatus) {
        this.callsstatus = callsstatus;
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
