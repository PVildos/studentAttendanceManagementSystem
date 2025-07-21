package com.example.model;

public class Course {
    private static int idIncrement = 1;
    private Integer courseId;
    private String courseName;
    private String instructor;

    public Course(String courseName, String instructor){
        this.courseName = courseName;
        this.instructor = instructor;
        this.courseId = idIncrement++;
    }

    public int getCourseId() {
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

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
