package com.example.hosp.analysis;

public class AnalysisRequestsClass {
    String caseaname;
String doctoename;
    String data;

    public AnalysisRequestsClass(String caseaname, String doctoename, String data) {
        this.caseaname = caseaname;
        this.doctoename = doctoename;
        this.data = data;
    }

    public String getCaseaname() {
        return caseaname;
    }

    public void setCaseaname(String caseaname) {
        this.caseaname = caseaname;
    }

    public String getDoctoename() {
        return doctoename;
    }

    public void setDoctoename(String doctoename) {
        this.doctoename = doctoename;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
