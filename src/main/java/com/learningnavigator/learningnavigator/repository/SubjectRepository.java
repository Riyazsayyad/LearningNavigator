package com.learningnavigator.learningnavigator.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.learningnavigator.learningnavigator.entity.*;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    
}

