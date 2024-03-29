package com.learningnavigator.learningnavigator.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    
    @JsonIgnore
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

    public void addEnrolledSubject(Subject subject) {
        if (enrolledSubjects == null) {
            enrolledSubjects = new ArrayList<>();
        }
        enrolledSubjects.add(subject);
        subject.getEnrolledStudents().add(this);
    }

}

