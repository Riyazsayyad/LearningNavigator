package com.learningnavigator.learningnavigator.entity;

import javax.persistence.*;
import java.util.List;
import lombok.*;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 

@Entity
public class Exam {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String examId;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToMany
    @JoinTable(name = "exam_student",
               joinColumns = @JoinColumn(name = "exam_id"),
               inverseJoinColumns = @JoinColumn(name = "student_id"))
    private List<Student> registeredStudents;
}

