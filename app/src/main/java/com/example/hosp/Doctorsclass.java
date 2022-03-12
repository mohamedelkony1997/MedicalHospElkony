package com.example.hosp;

public class Doctorsclass {
    String doctorname;
    String doctorstatus;
    String doctorsSpecialties;

    public Doctorsclass(String doctorname, String doctorstatus, String doctorsSpecialties) {
        this.doctorname = doctorname;
        this.doctorstatus = doctorstatus;
        this.doctorsSpecialties = doctorsSpecialties;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }

    public String getDoctorstatus() {
        return doctorstatus;
    }

    public void setDoctorstatus(String doctorstatus) {
        this.doctorstatus = doctorstatus;
    }

    public String getDoctorsSpecialties() {
        return doctorsSpecialties;
    }

    public void setDoctorsSpecialties(String doctorsSpecialties) {
        this.doctorsSpecialties = doctorsSpecialties;
    }
}
