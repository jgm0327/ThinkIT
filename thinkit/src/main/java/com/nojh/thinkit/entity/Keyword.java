package com.nojh.thinkit.entity;

import lombok.Getter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "KEYWORDS", indexes = @Index(columnList = "SUBJECTS_ID"))
public class Keyword {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KEYWORD_ID")
    @Getter
    private int id;

    @Column(name = "KEYWORD_NAME", nullable = false)
    @Getter
    private String name;

    @ManyToOne
    @JoinColumn(name = "SUBJECTS_ID")
    private Subject subject;

    @OneToMany(mappedBy = "keyword", cascade = CascadeType.ALL)
    private List<Concept> concepts;
}
