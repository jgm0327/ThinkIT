package com.nojh.thinkit.repository;

import com.nojh.thinkit.entity.Problem;
import com.nojh.thinkit.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem, Integer> {
    public Problem findBySubjectAndId(Subject subject, Integer id);
}
