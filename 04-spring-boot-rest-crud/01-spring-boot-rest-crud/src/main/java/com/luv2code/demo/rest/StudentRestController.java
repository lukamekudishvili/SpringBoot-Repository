package com.luv2code.demo.rest;

import com.luv2code.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;

    //define @PostConstruct to load the student data ... only once!
    @PostConstruct
    public void loadData() {
        System.out.println("2");
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Luka", "Mekudishvili"));
        theStudents.add(new Student("Ana", "Kutsia"));
        theStudents.add(new Student("Tinatin", "Tokhvadze"));
    }

    //define endpoint for "/api/students" - return list of students
    @GetMapping("/students")
    public List<Student> getStudentsList() {
        System.out.println("1");
        return theStudents;
    }

    //define another endpoint for bind path variable. "/api/students/{studentId}"
    // - return student on that studentId index in list
    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {
        //check the studentId
        if (studentId >= theStudents.size() || studentId < 0) {
            throw new StudentNotFoundException("Student id not found - " + studentId);
        } else {
            return theStudents.get(studentId);
        }
    }

    //add an exception handler using @ExceptionHandler

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
        // create a StudentErrorResponse
        StudentErrorResponse error= new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    //add another exception handler ... catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
        StudentErrorResponse error= new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Bad request gaichita, sxva rame scade");
        error.setTimeStamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}














