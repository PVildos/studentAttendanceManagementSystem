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
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

@WebServlet("/attendance")
public class AttendanceServlet extends HttpServlet {
    public void init() throws ServletException {}
    // Record new attendance
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            ArrayList<AttendanceRecord> attendanceList = DataStore.getAttendanceListFromFile();
            int studentId = parseInt(request.getParameter("newAttendanceStudentId"))   ;
            int courseId = parseInt(request.getParameter("newAttendanceCourseId"));
            boolean isPresent = parseBoolean(request.getParameter("newAttendanceIsPresent"));
            LocalDate lessonDate = LocalDate.parse(request.getParameter("newAttendanceLessonDate"));
            AttendanceRecord newAttendance  = new AttendanceRecord(studentId,courseId,lessonDate,isPresent);
            attendanceList.add(newAttendance);
            DataStore.storeStudentList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void destroy(){}
}
