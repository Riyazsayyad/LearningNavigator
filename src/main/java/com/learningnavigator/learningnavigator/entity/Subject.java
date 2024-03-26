package com.learningnavigator.learningnavigator.entity;

import javax.persistence.*;
import java.util.List;
import lombok.*;

@Data 
@NoArgsConstructor 
@AllArgsConstructor 

@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String subjectId;

    private String name;

    @ManyToMany(mappedBy = "enrolledSubjects")
    private List<Student> enrolledStudents;

    @OneToMany(mappedBy = "subject")
    private List<Exam> exams;
}
