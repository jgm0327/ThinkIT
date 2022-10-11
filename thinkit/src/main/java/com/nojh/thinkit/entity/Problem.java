package com.nojh.thinkit.entity;

import javax.persistence.*;

@Entity
@Table(name = "PROBLEMS", indexes = @Index(columnList = "SUBJECT_ID"))
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROBLEM_ID")
    private int id;

    @Column(name = "PROBLEM_TITLE")
    private String title;

    @Column(name = "PROBLEM_CONTENT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;
}
