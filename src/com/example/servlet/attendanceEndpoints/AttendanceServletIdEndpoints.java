package com.example.servlet.attendanceEndpoints;

import com.example.model.AttendanceRecord;
import com.example.model.Student;
import com.example.storage.DataStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

@WebServlet("/attendance/*")
public class AttendanceServletIdEndpoints extends HttpServlet {
    public void init() throws ServletException {}

    // Display Attendance record with student and courseId
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter attendanceOutput = response.getWriter()) {
            ArrayList<AttendanceRecord> attendanceList = DataStore.getAttendanceListFromFile();
            int studentId = parseInt(request.getParameter("getAttendanceStudentId"));
            int courseId = parseInt(request.getParameter("getAttendanceCourseId"));
            for (int i = 0; i < attendanceList.size(); i++) {
                if (attendanceList.get(i).getStudentId() == studentId
                        && attendanceList.get(i).getCourseId() == courseId) {
                    attendanceOutput.print("Attendance Id");
                    attendanceOutput.print("\t");
                    attendanceOutput.print("Student Id");
                    attendanceOutput.print("\t");
                    attendanceOutput.print("Course Id");
                    attendanceOutput.print("\t");
                    attendanceOutput.print("Lesson Date");
                    attendanceOutput.print("\t");
                    attendanceOutput.print("Attendance");
                    attendanceOutput.print("<br");
                    attendanceOutput.print(attendanceList.get(i).getAttendanceRecordId());
                    attendanceOutput.print("\t");
                    attendanceOutput.print(attendanceList.get(i).getStudentId());
                    attendanceOutput.print("\t");
                    attendanceOutput.print(attendanceList.get(i).getCourseId());
                    attendanceOutput.print("\t");
                    attendanceOutput.print(attendanceList.get(i).getLessonDate());
                    attendanceOutput.print("\t");
                    if (attendanceList.get(i).isPresent()) {
                        attendanceOutput.print("Present");
                    } else {
                        attendanceOutput.print("Absent");
                    }
                    attendanceOutput.println("<br>");
                }
            }
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Update Attendance Record
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<AttendanceRecord> attendanceList = DataStore.getAttendanceListFromFile();
            int attendanceId = parseInt(request.getParameter("updateAttendanceId"));
            int studentId = parseInt(request.getParameter("updateAttendanceStudentId"));
            int courseId = parseInt(request.getParameter("updateAttendanceCourseId"));
            boolean isPresent = parseBoolean(request.getParameter("updateAttendanceIsPresent"));
            LocalDate lessonDate = LocalDate.parse(request.getParameter("updateAttendanceLessonDate"));
            for (int i = 0; i< attendanceList.size(); i++) {
                if (attendanceList.get(i).getStudentId() == studentId) {
                    attendanceList.get(i).setStudentId(studentId);
                    attendanceList.get(i).setCourseId(courseId);
                    attendanceList.get(i).setLessonDate(lessonDate);
                    attendanceList.get(i).setPresent(isPresent);
                }
            }
            DataStore.storeStudentList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Delete Attendance Record
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<AttendanceRecord> attendanceList = DataStore.getAttendanceListFromFile();
            int attendanceId = parseInt(request.getParameter("deleteAttendanceId"));
            for (int i=0; i<attendanceList.size();i++){
                if (attendanceList.get(i).getStudentId() == attendanceId) {
                    attendanceList.remove(i);
                    DataStore.storeAttendanceList();
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void destroy(){}
}