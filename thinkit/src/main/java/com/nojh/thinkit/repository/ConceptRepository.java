package com.nojh.thinkit.repository;

import com.nojh.thinkit.entity.Concept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConceptRepository extends JpaRepository<Concept, Integer> {
    public Concept findByKeywordId(int id);
}
