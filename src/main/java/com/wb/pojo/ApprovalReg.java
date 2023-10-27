package com.wb.pojo;

public class ApprovalReg {

    String eventId;
    String name;
    String id;
    String dept_name;
    String courseName;
    String reason;

    String result;

    public ApprovalReg(String eventId, String name, String id, String dept_name, String courseName, String reason, String result) {
        this.eventId = eventId;
        this.name = name;
        this.id = id;
        this.dept_name = dept_name;
        this.courseName = courseName;
        this.reason = reason;
        this.result = result;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDept_name() {
        return dept_name;
    }

    public void setDept_name(String dept_name) {
        this.dept_name = dept_name;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ApprovalReg{" +
                "eventId='" + eventId + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", courseName='" + courseName + '\'' +
                ", reason='" + reason + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
