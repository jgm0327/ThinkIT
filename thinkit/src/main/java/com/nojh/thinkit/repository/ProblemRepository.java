package com.nojh.thinkit.repository;

import com.nojh.thinkit.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProblemRepository extends JpaRepository<Problem, Integer> {
    @Query(value = "select * from problems where subject_id = :subject_id order by rand() limit :cnt", nativeQuery = true)
    public List<Problem> selectByRandom(@Param("subject_id") int subject_id, @Param("cnt") int cnt);
}
