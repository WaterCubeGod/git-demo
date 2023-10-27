package com.wb.pojo;

public class ApprovalComment {
    String eventId;
    String teacherComment;
    String supervisorComment;
    String deanComment;

    public ApprovalComment(){

    }

    public ApprovalComment(String eventId, String teacherComment, String supervisorComment, String deanComment) {
        this.eventId = eventId;
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
        return "ApprovalComment{" +
                "eventId='" + eventId + '\'' +
                ", teacherComment='" + teacherComment + '\'' +
                ", supervisorComment='" + supervisorComment + '\'' +
                ", deanComment='" + deanComment + '\'' +
                '}';
    }
}
