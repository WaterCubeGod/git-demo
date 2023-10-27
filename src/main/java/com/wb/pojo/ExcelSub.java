package com.wb.pojo;

import com.alibaba.excel.annotation.ExcelProperty;

public class ExcelSub {
    @ExcelProperty("申请编号")
    private String subid;
    @ExcelProperty("学生ID")
    private String stuName;
    @ExcelProperty("课程名称")
    private String courseName;
    @ExcelProperty("审批开始时间")
    private String startTime;
    @ExcelProperty("审批结束时间")
    private String endTime;
    @ExcelProperty("申请进程")
    private String eventStatus;




    public ExcelSub(){

    }

    public ExcelSub(String subid, String stuName, String courseName, String startTime, String endTime, String eventStatus) {
        this.subid = subid;
        this.stuName = stuName;
        this.courseName = courseName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.eventStatus = eventStatus;
    }


    public String getSubid() {
        return subid;
    }

    public void setSubid(String subid) {
        this.subid = subid;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
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
}
