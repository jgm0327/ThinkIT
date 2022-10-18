package com.nojh.thinkit.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SUBJECTS")
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SUBJECT_ID")
    private int id;

    @Column(name = "SUBJECT_NAME", nullable = false)
    @Getter
    private String name;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Problem> problems;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<Keyword> keywords;

}
