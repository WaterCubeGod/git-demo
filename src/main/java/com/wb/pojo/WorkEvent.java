package com.wb.pojo;

public class WorkEvent {
    private String eventId;
    private int teacher;
    private int supervisor;
    private int dean;

    public WorkEvent(String eventId, int teacher, int supervisor, int dean) {
        this.eventId = eventId;
        this.teacher = teacher;
        this.supervisor = supervisor;
        this.dean = dean;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
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
        return "WorkEvent{" +
                "eventId=" + eventId +
                ", teacher=" + teacher +
                ", supervisor=" + supervisor +
                ", dean=" + dean +
                '}';
    }
}
