package com.learningnavigator.learningnavigator.entity;

import jakarta.persistence.*;
import java.util.List;
import lombok.*;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 

@Entity
@Table(name="STUDENT")

public class Student {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    private String registrationId;
    
    private String name;
    
    @ManyToMany
    @JoinTable(name = "student_subject",
               joinColumns = @JoinColumn(name = "student_id"),
               inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> enrolledSubjects;
    
    @ManyToMany(mappedBy = "registeredStudents")
    private List<Exam> registeredExams;

    public void registerForExam(Exam exam) {
        registeredExams.add(exam);
        exam.getRegisteredStudents().add(this);
    }

}

