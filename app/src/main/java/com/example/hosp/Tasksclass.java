package com.example.hosp;

public class Tasksclass {
    String taskname;
    String taskstatus;
    String taskdata;

    public Tasksclass(String taskname, String taskstatus, String taskdata) {
        this.taskname = taskname;
        this.taskstatus = taskstatus;
        this.taskdata = taskdata;
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    public String getTaskstatus() {
        return taskstatus;
    }

    public void setTaskstatus(String taskstatus) {
        this.taskstatus = taskstatus;
    }

    public String getTaskdata() {
        return taskdata;
    }

    public void setTaskdata(String taskdata) {
        this.taskdata = taskdata;
    }
}
