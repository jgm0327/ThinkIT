package com.nojh.thinkit.repository;

import com.nojh.thinkit.entity.InterviewProblem;
import com.nojh.thinkit.entity.Problem;
import com.nojh.thinkit.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterviewProblemRepository extends JpaRepository<InterviewProblem, Integer> {
    public InterviewProblem findBySubjectAndId(Subject subject, Integer id);
}
