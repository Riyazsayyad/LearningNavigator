package com.learningnavigator.learningnavigator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

import java.util.List;

import com.learningnavigator.learningnavigator.repository.*;
import com.learningnavigator.learningnavigator.entity.*;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Optional<Student> getStudentById(Long studentId) {
        return studentRepository.findById(studentId);
    }

    public Student updateStudent(Long studentId, Student updatedStudent) {
        Student existingStudent = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        existingStudent.setName(updatedStudent.getName());

        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }

    public void registerForExam(Long studentId, Long examId) {

        Student student = studentRepository.findById(studentId)
                                           .orElseThrow(() -> new IllegalArgumentException("Student not found with ID: " + studentId));
        Exam exam = examRepository.findById(examId)
                                   .orElseThrow(() -> new IllegalArgumentException("Exam not found with ID: " + examId));

        student.registerForExam(exam);
        studentRepository.save(student);
    }
}

