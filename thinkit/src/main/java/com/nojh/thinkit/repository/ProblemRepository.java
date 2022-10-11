package com.nojh.thinkit.repository;

import com.nojh.thinkit.entity.Concept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Concept, Integer> {
}
