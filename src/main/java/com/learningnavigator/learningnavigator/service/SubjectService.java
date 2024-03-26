package com.learningnavigator.learningnavigator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import com.learningnavigator.learningnavigator.repository.*;
import com.learningnavigator.learningnavigator.entity.*;

@Service
public class SubjectService {

    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject createSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

}

