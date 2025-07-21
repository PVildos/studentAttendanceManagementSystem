package com.example.servlet;

import com.example.model.Course;
import com.example.storage.DataStore;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class CourseServlet {
    @WebServlet(urlPatterns = "/courses")
    public class StudentServlet extends HttpServlet {
        public void init() throws ServletException {
        }

        // Display Course List
        public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try (PrintWriter courseListOutput = response.getWriter();) {
                ArrayList<Course> courseList = DataStore.getCourseListFromFile();
                for (int i = 0; i < courseList.size(); i++) {
                    courseListOutput.write("Course Id");
                    courseListOutput.println("\t");
                    courseListOutput.write("Course Name");
                    courseListOutput.println("\t");
                    courseListOutput.write("Instructor");
                    courseListOutput.println("<br>");
                    courseListOutput.write(courseList.get(i).getCourseId());
                    courseListOutput.println("\t");
                    courseListOutput.write(courseList.get(i).getCourseName());
                    courseListOutput.println("\t");
                    courseListOutput.write(courseList.get(i).getInstructor());
                    courseListOutput.println("<br>");
                }
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        //Add New Course
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                ArrayList<Course> courseList = DataStore.getCourseListFromFile();
                String courseName = request.getParameter("newCourseName");
                String instructor = request.getParameter("newCourseInstructor");
                Course newCourse  = new Course(courseName,instructor);
                courseList.add(newCourse);
                DataStore.storeCourseList();
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }

        public void destroy() {
        }
    }
}
