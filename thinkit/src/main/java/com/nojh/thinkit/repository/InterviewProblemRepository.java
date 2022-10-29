package com.nojh.thinkit.repository;

import com.nojh.thinkit.entity.InterviewProblem;
import com.nojh.thinkit.entity.Problem;
import com.nojh.thinkit.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InterviewProblemRepository extends JpaRepository<InterviewProblem, Integer> {
    @Query(value = "select * from interview_problems where subject_id = :subject_id order by rand() limit :cnt", nativeQuery = true)
    public List<InterviewProblem> selectByRandom(@Param("subject_id") int subject_id, @Param("cnt") int cnt);
}
