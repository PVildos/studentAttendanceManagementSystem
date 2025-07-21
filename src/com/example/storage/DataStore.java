package com.example.storage;

import com.example.model.AttendanceRecord;
import com.example.model.Course;
import com.example.model.Student;

import java.io.*;
import java.util.ArrayList;

public class DataStore implements Serializable{
    private static ArrayList<Student> students;
    private static ArrayList<Course> courses;
    private static ArrayList<AttendanceRecord> attendanceRecords;

    public static ArrayList<Student> getStudentListFromFile(){
        try (FileInputStream studentListFile = new FileInputStream("storage/students/students.ser");
             ObjectInputStream studentListFileInput = new ObjectInputStream(studentListFile)){
             students = (ArrayList<Student>) studentListFileInput.readObject();
            return students;
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<Student>();
    }

    public static void storeStudentList(){
        try{
            File studentList = new File ("storage/students/students.ser");
            if (studentList.exists()) {studentList.delete();}
            FileOutputStream studentListFile = new FileOutputStream("storage/students/students.ser");
            ObjectOutputStream studentListFileOutput = new ObjectOutputStream(studentListFile);
            studentListFileOutput.writeObject(students);
            studentListFile.close();
            studentListFileOutput.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<Course> getCourseListFromFile(){
        try (FileInputStream courseListFile = new FileInputStream("/storage/courses/courses.ser");
             ObjectInputStream courseListFileInput = new ObjectInputStream(courseListFile);){
            ArrayList<Course> courses = (ArrayList<Course>) courseListFileInput.readObject();
            return courses;
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<Course>();
    }

    public static void storeCourseList(){
        try{
            File courseList = new File ("/storage/courses/courses.ser");
            if (courseList.exists()) {courseList.delete();}
            FileOutputStream courseListFile = new FileOutputStream("/storage/courses/courses.ser");
            ObjectOutputStream courseListFileOutput = new ObjectOutputStream(courseListFile);
            courseListFileOutput.writeObject(courses);
            courseListFile.close();
            courseListFileOutput.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static ArrayList<AttendanceRecord> getAttendanceListFromFile(){
        try (FileInputStream attendanceListFile = new FileInputStream("/storage/attendanceRecords/attendance.ser");
             ObjectInputStream attendanceListFileInput = new ObjectInputStream(attendanceListFile);){
            ArrayList<AttendanceRecord> attendanceRecords = (ArrayList<AttendanceRecord>) attendanceListFileInput.readObject();
            return attendanceRecords;
        }catch (FileNotFoundException e){
            System.out.println("File not found");
        }catch (ClassNotFoundException e){
            System.out.println("Class not found");
        }catch (IOException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return new ArrayList<AttendanceRecord>();
    }

    public static void storeAttendanceList(){
        try{
            File attendanceList = new File ("/storage/attendanceRecords/attendance.ser");
            if (attendanceList.exists()) {attendanceList.delete();}
            FileOutputStream attendanceListFile = new FileOutputStream("/storage/attendanceRecords/attendance.ser");
            ObjectOutputStream attendanceListFileOutput = new ObjectOutputStream(attendanceListFile);
            attendanceListFileOutput.writeObject(attendanceRecords);
            attendanceListFile.close();
            attendanceListFileOutput.close();
        }catch (IOException e) {
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public ArrayList<AttendanceRecord> getAttendanceRecords() {
        return attendanceRecords;
    }

    public void setAttendanceRecords(ArrayList<AttendanceRecord> attendanceRecords) {
        this.attendanceRecords = attendanceRecords;
    }
}