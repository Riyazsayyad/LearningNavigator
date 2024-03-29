package com.learningnavigator.learningnavigator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.learningnavigator.learningnavigator.service.*;
import com.learningnavigator.learningnavigator.entity.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> students = studentService.getAllStudents();
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        Optional<Student> student = studentService.getStudentById(studentId);
        return new ResponseEntity<>(student.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student createdStudent = studentService.createStudent(student);
        return new ResponseEntity<>(createdStudent, HttpStatus.CREATED);
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long studentId, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudent(studentId, student);
        return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
        studentService.deleteStudent(studentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{studentId}/register/{examId}")
    public ResponseEntity<Void> registerForExam(@PathVariable Long studentId, @PathVariable Long examId) {
        studentService.registerForExam(studentId, examId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/{studentId}/enroll-subject/{subjectId}")
    public ResponseEntity<Void> enrollStudentForSubject(@PathVariable Long studentId, @PathVariable Long subjectId) {
        studentService.enrollStudentForSubject(studentId, subjectId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

