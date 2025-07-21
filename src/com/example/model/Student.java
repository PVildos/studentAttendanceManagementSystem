package com.example.model;

import java.util.ArrayList;

public class Student {
    private static int idIncrement = 1;
    private Integer studentId;
    private String studentFullName;
    private String studentEmail;
    private String[] registeredCourses;

    public Student(String studentFullName,
                   String studentEmail, String[] registeredCourses){
        this.studentId = idIncrement++;
        this.studentFullName = studentFullName;
        this.studentEmail = studentEmail;
        this.registeredCourses = registeredCourses;

    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentFullName() {
        return studentFullName;
    }

    public void setStudentFullName(String studentFullName) {
        this.studentFullName = studentFullName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String[] getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(String[] registeredCourses) {
        this.registeredCourses = registeredCourses;
    }
}
