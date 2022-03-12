package com.example.hosp;

public class Reportsclass {
    String reportsname;
    String reportstatus;
    String reportdata;

    public Reportsclass(String reportsname, String reportstatus, String reportdata) {
        this.reportsname = reportsname;
        this.reportstatus = reportstatus;
        this.reportdata = reportdata;
    }

    public String getReportsname() {
        return reportsname;
    }

    public void setReportsname(String reportsname) {
        this.reportsname = reportsname;
    }

    public String getReportstatus() {
        return reportstatus;
    }

    public void setReportstatus(String reportstatus) {
        this.reportstatus = reportstatus;
    }

    public String getReportdata() {
        return reportdata;
    }

    public void setReportdata(String reportdata) {
        this.reportdata = reportdata;
    }
}
