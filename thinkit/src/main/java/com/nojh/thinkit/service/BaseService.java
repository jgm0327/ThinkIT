package com.nojh.thinkit.service;

import com.nojh.thinkit.entity.Keyword;
import com.nojh.thinkit.repository.ConceptRepository;
import com.nojh.thinkit.repository.KeywordRepository;
import com.nojh.thinkit.repository.ProblemRepository;
import com.nojh.thinkit.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BaseService {
    private final ConceptRepository conceptRepository;
    private final KeywordRepository keywordRepository;
    private final SubjectRepository subjectRepository;
    private final ProblemRepository problemRepository;

    public List<String> getKeywords(int id){
        List<Keyword> list = keywordRepository.findBySubjectId(id);
        List<String> keyword_names = new ArrayList<>();
        for(Keyword keyword : list){
            keyword_names.add(keyword.getName());
        }
        return keyword_names;
    }
}
