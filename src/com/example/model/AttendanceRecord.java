package com.example.model;

import java.time.LocalDate;
import java.util.Date;

public class AttendanceRecord {
    private static int idIncrement = 1;
    private Integer attendanceRecordId;
    private Integer studentId;
    private Integer courseId;
    private LocalDate lessonDate;
    private boolean isPresent;

    public AttendanceRecord(Integer studentId, Integer courseId, LocalDate lessonDate, boolean isPresent){
        this.studentId = studentId;
        this.courseId = courseId;
        this.lessonDate = lessonDate;
        this.isPresent = isPresent;
        this.attendanceRecordId = idIncrement++;
    }

    public int getAttendanceRecordId() {
        return attendanceRecordId;
    }

    public void setAttendanceRecordId(Integer attendanceRecordId) {
        this.attendanceRecordId = attendanceRecordId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public LocalDate getLessonDate() {
        return lessonDate;
    }

    public void setLessonDate(LocalDate lessonDate) {
        this.lessonDate = lessonDate;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }
}
