package com.wb.pojo;

public class CourseLicense {
    private String courseId;
    private String name;
    private String license;

    public CourseLicense(String courseId, String name, String license) {
        this.courseId = courseId;
        this.name = name;
        this.license = license;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "courseLicense{" +
                "courseId='" + courseId + '\'' +
                ", name='" + name + '\'' +
                ", license='" + license + '\'' +
                '}';
    }
}