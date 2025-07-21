package com.example.servlet.studentEndpoints;

import com.example.model.Student;
import com.example.storage.DataStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;

// Create student, attendance, and course endpoint packages to contain the different servlets
// store data: Serialize objects to files(category+id.ser e.g. student1.ser) (user.home? or project directory?) using ObjectOutputStream
@WebServlet(urlPatterns = "/students")
public class StudentServlet extends HttpServlet {
    public void init() throws ServletException {

    }
    // Display Student List
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (PrintWriter studentListOutput = response.getWriter()) {
            ArrayList<Student> studentList = DataStore.getStudentListFromFile();
            for (int i = 0; i < studentList.size(); i++) {
                studentListOutput.write("Student List");
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
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // Add New Student
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Student> studentList = DataStore.getStudentListFromFile();
        String studentFullName = request.getParameter("newStudentFullName");
        String studentEmail = request.getParameter("newStudentEmail");
        String[] registeredCourses = request.getParameter("newStudentRegisteredCourses").split(",");
        Student newStudent  = new Student(studentFullName,studentEmail, registeredCourses);
        studentList.add(newStudent);
        DataStore.storeStudentList();
    }

    public void destroy(){}

}
