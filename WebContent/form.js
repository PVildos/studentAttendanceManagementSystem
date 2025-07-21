document.addEventListener("DOMContentLoaded", ()=>{
    RESTMethods();
})

function RESTMethods(){
    let updateStudentButton = document.getElementById("updateStudentButton");
    let deleteStudentButton = document.getElementById("deleteStudentButton");
    let updateAttendanceButton = document.getElementById("updateAttendanceButton");
    let deleteAttendanceButton = document.getElementById("deleteAttendanceButton");
    let getStudentListButton document.getElementById("getStudentListButton")
    let getCourseListButton = document.getElementById("getCourseListButton");
    let getStudentByIdButton = document.getElementById("getStudentByIdButton");
    let getAttendanceByIdButton = document.getElementById("getAttendanceByIdButton");
    let newStudentButton = document.getElementById("newStudentButton");
    let newAttendanceButton = document.getElementById("newAttendanceButton");
    let newCourseButton = document.getElementById("newCourseButton");
    updateStudentButton.addEventListener("click", studentPut);
    deleteStudentButton.addEventListener("click", studentDelete);
    updateAttendanceButton.addEventListener("click", attendancePut);
    deleteAttendanceButton.addEventListener("click", attendanceDelete);
    getStudentListButton.addEventListener("click", studentListGet);
    getCourseListButton.addEventListener("click", courseListGet);
    getStudentByIdButton.addEventListener("click", studentGetById);
    getAttendanceByIdButton.addEventListener("click", attendanceGetById);
    newStudentButton.addEventListener("click", studentPost);
    newAttendanceButton.addEventListener("click", attendancePost);
    newCourseButton.addEventListener("click", coursePost);
}

function studentPut(){
    let updateStudentId = document.getElementById("updateStudentId");
    fetch("http://localhost:8080/studentAttendanceManagementSystem/students/"+updateStudentId, {
    method: "PUT",
    headers: {
        "Content-Type": "application/x-www-form-urlencoded"
    },
    body: new URLSearchParams({,
        updateStudentFullName: document.getElementById("updateStudentFullName").textContent,
        updateStudentEmail: document.getElementById("updateStudentEmail").textContent,
        updateStudentRegisteredCourses: document.getElementById("updateStudentRegisteredCourses").textContent
    })
})
.then(response => {
    if (!response.ok) {
        throw new Error("PUT request failed: " + response.status);
    }
    return response.text();
})
.then(data => {
    console.log("Response from server:", data);
})
.catch(error => {
    console.error("Error:", error);
});
}

function attendancePut(){
    let updateAttendanceId = document.getElementById("updateAttendanceId");

    fetch("http://localhost:8080/studentAttendanceManagementSystem/attendance/"+updateStudentId, {
    method: "PUT",
    headers: {
        "Content-Type": "application/x-www-form-urlencoded"
    },
    body: new URLSearchParams({
        updateAttendanceId: document.getElementById("updateAttendanceId").textContent,
        updateAttendanceStudentId: document.getElementById("updateAttendanceStudentId").textContent,
        updateAttendanceCourseId: document.getElementById("updateAttendanceCourseId").textContent,
        updateAttendanceLessonDate: document.getElementById("updateAttendanceLessonDate").textContent,
        updateAttendanceIsPresent:  document.getElementById("updateAttendanceIsPresent").textContent
    })
})
.then(response => {
    if (!response.ok) {
        throw new Error("PUT request failed: " + response.status);
    }
    return response.text();
})
.then(data => {
    console.log("Response from server:", data);
})
.catch(error => {
    console.error("Error:", error);
});
}

function studentDelete(){
    let deleteStudentId = document.getElementById("deleteStudentId");

    fetch("http://localhost:8080/studentAttendanceManagementSystem/students"+deleteStudentId, {
    method: "DELETE",
    headers: {
        "Content-Type": "application/x-www-form-urlencoded"
    },
    body: new URLSearchParams({
        deleteStudentId: document.getElementById("deleteStudentId")
    })
})
.then(response => {
    if (!response.ok) {
        throw new Error("Delete failed: " + response.status);
    }
    return response.text();
})
.then(data => {
    console.log("Server response:", data);
})
.catch(error => {
    console.error("Error:", error);
});
}

function attendanceDelete(){
    let deleteAttendanceId = document.getElementById("deleteAttendanceId");

        fetch("http://localhost:8080/studentAttendanceManagementSystem/students"+deleteAttendanceId, {
    method: "DELETE",
    headers: {
        "Content-Type": "application/x-www-form-urlencoded"
    },
    body: new URLSearchParams({
        deleteAttendanceId: document.getElementById("deleteAttendanceId")
    })
})
.then(response => {
    if (!response.ok) {
        throw new Error("Delete failed: " + response.status);
    }
    return response.text();
})
.then(data => {
    console.log("Server response:", data);
})
.catch(error => {
    console.error("Error:", error);
});
}

function attendanceGetById(){
    let getAttendanceId = document.getElementById("getAttendanceId");

    fetch("http://localhost:8080/studentAttendanceManagementSystem/attendance/"+getAttendanceId, {
    headers: {
            "Content-Type": "application/x-www-form-urlencoded"
        },
        body: new URLSearchParams({
            getAttendanceId: document.getElementById("getAttendanceId").textContent,
            getAttendanceStudentId: document.getElementById("getAttendanceStudentId").textContent,
            getAttendanceCourseId: document.getElementById("getAttendanceCourseId").textContent
        })
       })
      .then(response => {
        if (!response.ok) {
          throw new Error("Failed to fetch attendance");
        }
        return response.text();
      })
      .then(data => {
        console.log("Attendance data:", data);
      })
      .catch(error => {
        console.error("Error fetching attendance:", error);
      });
}

function studentGetById(){
    let getStudentId = document.getElementById("getStudentId").textContent;

    fetch("http://localhost:8080/studentAttendanceManagementSystem/students/"+getStudentId)
      .then(response => {
        if (!response.ok) {
          throw new Error("Failed to fetch student");
        }
        return response.text();
      })
      .then(data => {
        console.log("Attendance data:", data);
      })
      .catch(error => {
        console.error("Error fetching student:", error);
      });
}

function studentListGet(){
    fetch("http://localhost:8080/studentAttendanceManagementSystem/students)
      .then(response => {
        if (!response.ok) {
          throw new Error("Failed to fetch student list");
        }
        return response.text();
      })
      .then(data => {
      })
      .catch(error => {
        console.error("Error:", error);
      });

}

function courseListGet(){
    fetch("http://localhost:8080/studentAttendanceManagementSystem/courses)
      .then(response => {
        if (!response.ok) {
          throw new Error("Failed to fetch course list");
        }
        return response.text();
      })
      .then(data => {
      })
      .catch(error => {
        console.error("Error:", error);
      });

}

function studentPost(){
    fetch("http://localhost:8080/studentAttendanceManagementSystem/students, {
      method: "POST",
      headers: {
        "Content-Type": "application/x-www-form-urlencoded"
      },
      body: new URLSearchParams({
        newStudentFullName: document.getElementById("newStudentFullName")
        newStudentEmail: document.getElementById("newStudentEmail"),
        newStudentRegisteredCourses: document.getElementById("newStudentRegisteredCourses")
      })
    })
    .then(response => {
      if (!response.ok) {
        throw new Error("Failed to add student");
      }
      return response.text();
    })
    .then(data => {
      console.log("Server response:", data);
    })
    .catch(error => {
      console.error("Error:", error);
    });
}

function attendancePost{
        fetch("http://localhost:8080/studentAttendanceManagementSystem/attendance", {
          method: "POST",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          body: new URLSearchParams({
            newAttendanceStudentId: document.getElementById("newAttendanceStudentId").textContent
            newAttendanceCourseId: document.getElementById("newAttendanceCourseId").textContent,
            newAttendanceLessonDate: document.getElementById("newAttendanceLessonDate").textContent,
            newAttendanceIsPresent: document.getElementById("newAttendanceIsPresent").textContent,
          })
        })
        .then(response => {
          if (!response.ok) {
            throw new Error("Failed to add attendance record");
          }
          return response.text();
        })
        .then(data => {
          console.log("Server response:", data);
        })
        .catch(error => {
          console.error("Error:", error);
        });
}

function coursePost(){
        fetch("http://localhost:8080/studentAttendanceManagementSystem/courses", {
          method: "POST",
          headers: {
            "Content-Type": "application/x-www-form-urlencoded"
          },
          body: new URLSearchParams({
            newCourseName: document.getElementById("newCourseName").textContent,
            newCourseInstructor: document.getElementById("newCourseInstructor").textContent
          })
        })
        .then(response => {
          if (!response.ok) {
            throw new Error("Failed to add course");
          }
          return response.text();
        })
        .then(data => {
          console.log("Server response:", data);
        })
        .catch(error => {
          console.error("Error:", error);
        });
}
