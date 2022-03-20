package com.example.hosp.manger;

public class MainTasksclass {
    String taskname;
    String taskstatus;
    String taskdata;

    public MainTasksclass(String taskname, String taskstatus, String taskdata) {
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
