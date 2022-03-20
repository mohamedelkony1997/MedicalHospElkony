package com.example.hosp.hr;

public class Employeeclass {
    String doctorname;
    String doctorstatus;
    String doctorsSpecialties;

    public Employeeclass(String doctorname,  String doctorsSpecialties) {
        this.doctorname = doctorname;

        this.doctorsSpecialties = doctorsSpecialties;
    }

    public String getDoctorname() {
        return doctorname;
    }

    public void setDoctorname(String doctorname) {
        this.doctorname = doctorname;
    }



    public String getDoctorsSpecialties() {
        return doctorsSpecialties;
    }

    public void setDoctorsSpecialties(String doctorsSpecialties) {
        this.doctorsSpecialties = doctorsSpecialties;
    }
}
