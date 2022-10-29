package com.nojh.thinkit.repository;

import com.nojh.thinkit.entity.Keyword;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeywordRepository extends JpaRepository<Keyword, Integer> {
    public List<Keyword> findBySubjectId(int id);

    public Keyword findByNameEquals(String name);
}
