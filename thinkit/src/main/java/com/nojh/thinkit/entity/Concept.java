package com.nojh.thinkit.entity;

import javax.persistence.*;

@Entity
@Table(name = "CONCEPTS", indexes = @Index(columnList = "KEYWORD_ID"))
public class Concept {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CONCEPT_ID")
    private int id;

    @Column(name = "CONCEPT_CONTENT")
    private String content;

    @ManyToOne
    @JoinColumn(name = "KEYWORD_ID")
    private Keyword keyword;
}
