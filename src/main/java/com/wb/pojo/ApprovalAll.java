package com.wb.pojo;

public class ApprovalAll {
    String eventId;
    String name;
    String id;
    String dept_name;
    String courseName;
    String reason;
    String teacherComment;
    String supervisorComment;
    String deanComment;

    public ApprovalAll(){

    }

    public ApprovalAll(String eventId, String name, String id, String dept_name, String courseName, String reason, String teacherComment, String supervisorComment, String deanComment) {
        this.eventId = eventId;
        this.name = name;
        this.id = id;
        this.dept_name = dept_name;
        this.courseName = courseName;
        this.reason = reason;
        this.teacherComment = teacherComment;
        this.supervisorComment = supervisorComment;
        this.deanComment = deanComment;
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

    public String getTeacherComment() {
        return teacherComment;
    }

    public void setTeacherComment(String teacherComment) {
        this.teacherComment = teacherComment;
    }

    public String getSupervisorComment() {
        return supervisorComment;
    }

    public void setSupervisorComment(String supervisorComment) {
        this.supervisorComment = supervisorComment;
    }

    public String getDeanComment() {
        return deanComment;
    }

    public void setDeanComment(String deanComment) {
        this.deanComment = deanComment;
    }

    @Override
    public String toString() {
        return "ApprovalAll{" +
                "eventId='" + eventId + '\'' +
                ", name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", dept_name='" + dept_name + '\'' +
                ", courseName='" + courseName + '\'' +
                ", reason='" + reason + '\'' +
                ", teacherComment='" + teacherComment + '\'' +
                ", supervisorComment='" + supervisorComment + '\'' +
                ", deanComment='" + deanComment + '\'' +
                '}';
    }
}
