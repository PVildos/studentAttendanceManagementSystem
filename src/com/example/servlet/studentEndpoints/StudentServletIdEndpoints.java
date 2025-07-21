package com.example.servlet.studentEndpoints;

import com.example.model.Course;
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
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Integer.parseInt;

@WebServlet("/students/*")
public class StudentServletIdEndpoints {
    public void init() throws ServletException {
    }

    //Get Student by Id
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter studentListOutput = response.getWriter()) {
            int studentId = parseInt(request.getParameter("getStudentId"));
            ArrayList<Student> studentList = DataStore.getStudentListFromFile();
            for (int i = 0; i < studentList.size(); i++) {
                if (studentList.get(i).getStudentId() == studentId) {
                    studentListOutput.write("<br>");
                    studentListOutput.write("Student Id");
                    studentListOutput.println("\t");
                    studentListOutput.write("Full Name");
                    studentListOutput.println("\t");
                    studentListOutput.write("Email");
                    studentListOutput.println("\t");
                    studentListOutput.write("Registered Course Ids");
                    studentListOutput.println("\t");
                    studentListOutput.print("<br>");
                    studentListOutput.write(studentList.get(i).getStudentId());
                    studentListOutput.println("\t");
                    studentListOutput.write(studentList.get(i).getStudentFullName());
                    studentListOutput.println("\t");
                    studentListOutput.write(studentList.get(i).getStudentEmail());
                    studentListOutput.println("\t");
                    studentListOutput.print(Arrays.toString(studentList.get(i).getRegisteredCourses()));
                    studentListOutput.println("<br>");
                } else {
                    studentListOutput.write("Student not found");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // Update Student Information
    public void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Student> studentList = DataStore.getStudentListFromFile();
            int studentId = parseInt(request.getParameter("updateStudentId"));
            String studentFullName = request.getParameter("updateStudentFullName");
            String studentEmail = request.getParameter("updateStudentEmail");
            String[] registeredCourses = request.getParameter("updateStudentRegisteredCourses").split(",");
            for (int i=0; i<studentList.size();i++) {
                if (studentList.get(i).getStudentId() == studentId) {
                    studentList.get(i).setStudentFullName(studentFullName);
                    studentList.get(i).setStudentEmail(studentEmail);
                    studentList.get(i).setRegisteredCourses(registeredCourses);
                }
            }
            DataStore.storeStudentList();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Delete Student
    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ArrayList<Student> studentList = DataStore.getStudentListFromFile();
            int studentId = parseInt(request.getParameter("deleteStudentId"));
            for (int i=0; i<studentList.size();i++){
                if (studentList.get(i).getStudentId() == studentId) {
                    studentList.remove(i);
                    DataStore.storeStudentList();
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void destroy() {
    }

}
