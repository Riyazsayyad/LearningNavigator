package com.learningnavigator.learningnavigator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.learningnavigator.learningnavigator.repository.*;
import com.learningnavigator.learningnavigator.entity.*;

@Service
public class ExamService {

    @Autowired
    private ExamRepository examRepository;

    public List<Exam> getAllExams() {
        return examRepository.findAll();
    }

    public Exam registerStudentForExam(Long examId, Student student) {
        Exam exam = examRepository.findById(examId)
                                  .orElseThrow(() -> new RuntimeException("Exam not found"));

        List<Student> registeredStudents = exam.getRegisteredStudents();
        registeredStudents.add(student);
        exam.setRegisteredStudents(registeredStudents);

        return examRepository.save(exam);
    }

}
