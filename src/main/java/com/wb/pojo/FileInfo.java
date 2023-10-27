package com.wb.pojo;

import java.io.Serializable;
import java.util.Date;

public class FileInfo implements Serializable {
    private int eventId;
    private String realFileName;
    private String fileType;
    private String fileSize;

    public FileInfo(){

    }

    public FileInfo(int eventId, String realFileName, String fileType, String fileSize) {
        this.eventId = eventId;
        this.realFileName = realFileName;
        this.fileType = fileType;
        this.fileSize = fileSize;
    }

    public String getRealFileName() {
        return realFileName;
    }

    public void setRealFileName(String realFileName) {
        this.realFileName = realFileName;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    @Override
    public String toString() {
        return "FileInfo{" +
                "eventId=" + eventId +
                ", realFileName='" + realFileName + '\'' +
                ", fileType='" + fileType + '\'' +
                ", fileSize='" + fileSize + '\'' +
                '}';
    }
}
