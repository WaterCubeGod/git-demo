package com.wb.pojo;

public class WorkFlow {
    private String deptName;
    private int teacher;
    private int supervisor;
    private int dean;

    public WorkFlow(){

    }

    public WorkFlow(String deptName,int teacher, int supervisor, int dean) {
        this.deptName = deptName;
        this.teacher = teacher;
        this.supervisor = supervisor;
        this.dean = dean;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getTeacher() {
        return teacher;
    }

    public void setTeacher(int teacher) {
        this.teacher = teacher;
    }

    public int getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(int supervisor) {
        this.supervisor = supervisor;
    }

    public int getDean() {
        return dean;
    }

    public void setDean(int dean) {
        this.dean = dean;
    }

    @Override
    public String toString() {
        return "WorkFlow{" +
                "deptName='" + deptName + '\'' +
                ", teacher=" + teacher +
                ", supervisor=" + supervisor +
                ", dean=" + dean +
                '}';
    }
}
