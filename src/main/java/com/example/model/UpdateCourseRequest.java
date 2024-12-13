package com.example.model;

public class UpdateCourseRequest {
    private Integer courseId;
    private String courseName;

    // Getter 및 Setter
    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}

