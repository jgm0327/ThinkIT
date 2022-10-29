package com.nojh.thinkit.repository;

import com.nojh.thinkit.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    public Subject findByNameEquals(String name);
}
