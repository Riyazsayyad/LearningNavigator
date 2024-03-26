package com.learningnavigator.learningnavigator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.learningnavigator.learningnavigator.entity.Exam;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    
}
