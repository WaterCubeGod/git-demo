package com.wb.pojo;

public class ApprovalEvent {
    private String eventId;
    private String id;
    private String courseName;
    private String startTime;
    private String endTime;
    private String eventStatus;

    public ApprovalEvent(){

    }

    public ApprovalEvent(String eventId, String id,String courseName, String startTime, String endTime, String eventStatus) {
        this.eventId = eventId;
        this.id = id;
        this.courseName = courseName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventStatus = eventStatus;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getEventStatus() {
        return eventStatus;
    }

    public void setEventStatus(String eventStatus) {
        this.eventStatus = eventStatus;
    }

    @Override
    public String toString() {
        return "ApprovalEvent{" +
                "eventId='" + eventId + '\'' +
                ", id='" + id+ '\'' +
                ", courseName='" + courseName + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", eventStatus='" + eventStatus + '\'' +
                '}';
    }
}
