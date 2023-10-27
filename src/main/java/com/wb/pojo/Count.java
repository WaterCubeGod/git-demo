package com.wb.pojo;

public class Count {
    private int students;
    private int teachers;
    private int supervisors;
    private int deans;

    public Count(){

    }

    public Count(int students, int teachers, int supervisors, int deans) {
        this.students = students;
        this.teachers = teachers;
        this.supervisors = supervisors;
        this.deans = deans;
    }

    public int getStudents() {
        return students;
    }

    public void setStudents(int students) {
        this.students = students;
    }

    public int getTeachers() {
        return teachers;
    }

    public void setTeachers(int teachers) {
        this.teachers = teachers;
    }

    public int getSupervisors() {
        return supervisors;
    }

    public void setSupervisors(int supervisors) {
        this.supervisors = supervisors;
    }

    public int getDeans() {
        return deans;
    }

    public void setDeans(int deans) {
        this.deans = deans;
    }

    @Override
    public String toString() {
        return "Count{" +
                "students=" + students +
                ", teachers=" + teachers +
                ", supervisors=" + supervisors +
                ", deans=" + deans +
                '}';
    }
}
