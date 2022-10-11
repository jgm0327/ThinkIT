package com.nojh.thinkit.repository;

import com.nojh.thinkit.entity.Concept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Concept, Integer> {
}
