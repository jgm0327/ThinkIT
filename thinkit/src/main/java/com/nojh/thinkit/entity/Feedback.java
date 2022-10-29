package com.nojh.thinkit.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "FEEDBACKS", indexes = {@Index(columnList = "FEEDBACK_ID")})
@NoArgsConstructor
public class Feedback {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FEEDBACK_ID")
    private Long id;

    @Column(name = "FEEDBACK_CONTENT")
    @Getter
    private String content;

    public Feedback(String content){
        this.content = content;
    }
}
