# Student Attendance Management System

A lightweight Java Servlet-based web application for managing students, courses, and attendance records via RESTful endpoints. Designed for educational institutions or training environments that need a simple, deployable solution without external databases or frameworks.

---

## Features

- **Student Management**: Add, view, update, and delete student records
- **Course Management**: Add, view, and delete courses
- **Attendance Tracking**: Record and retrieve attendance by student ID and course ID
- **RESTful Endpoints**: Interact using HTTP methods (`GET`, `POST`, `PUT`, `DELETE`)
- **Frontend Testing**: Simple HTML/JavaScript interface for quick interaction
- **Tomcat-Ready**: Easily deployable as a `.war` file

---

## Tech Stack

- Java Servlets (no frameworks)
- HTML + JavaScript
- In-memory storage (data is lost when server stops)
- Manual build process (no Maven/Gradle)

---

## Project Structure

* studentAttendanceManagementSystem/
* ├── src/ # Java source files 
* │ └── com/example/... # Servlets, model, storage
* ├── out/production/... # class files 
* ├── WebContent/ # HTML, JS
* ├── WEB-INF/ # web.xml  
* ├── studentAttendanceManagementSystem.war 
* ├── README.md

## How to deploy

Drop the .war file into TOMCAT_HOME/webapps/
Start Tomcat and visit: http://localhost:8080/studentAttendanceManagementSystem/index.html

