package com.learningnavigator.learningnavigator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exams")
public class ExamController {

    @Autowired
    private ExamService examService;

    @GetMapping
    public ResponseEntity<List<Exam>> getAllExams() {
        List<Exam> exams = examService.getAllExams();
        return new ResponseEntity<>(exams, HttpStatus.OK);
    }

    @PostMapping("/{examId}")
    public ResponseEntity<Exam> registerStudentForExam(@PathVariable Long examId, @RequestBody Student student) {
        Exam registeredExam = examService.registerStudentForExam(examId, student);
        return new ResponseEntity<>(registeredExam, HttpStatus.OK);
    }

    // Other CRUD endpoints for Exam entity

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

