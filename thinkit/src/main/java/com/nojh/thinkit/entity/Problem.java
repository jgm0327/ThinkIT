package com.nojh.thinkit.entity;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Table(name = "PROBLEMS", indexes = @Index(columnList = "SUBJECT_ID"))
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PROBLEM_ID")
    private int id;

    @Column(name = "PROBLEM_TITLE")
    @Getter
    private String title;

    @Column(name = "PROBLEM_CONTENT")
    @Getter
    private String content;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID")
    private Subject subject;
}
