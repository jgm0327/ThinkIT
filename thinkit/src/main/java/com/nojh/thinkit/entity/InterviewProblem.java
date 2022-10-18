package com.nojh.thinkit.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "INTERVIEW_PROBLEMS", indexes = @Index(columnList = "SUBJECT_ID"))
public class InterviewProblem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROBLEM_ID")
    private int id;

    @Column(name = "PROBLEM_CONTENT")
    @Getter
    private String content;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;
}
