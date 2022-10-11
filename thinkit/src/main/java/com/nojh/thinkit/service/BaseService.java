package com.nojh.thinkit.service;

import com.nojh.thinkit.entity.Concept;
import com.nojh.thinkit.entity.Keyword;
import com.nojh.thinkit.repository.ConceptRepository;
import com.nojh.thinkit.repository.KeywordRepository;
import com.nojh.thinkit.repository.ProblemRepository;
import com.nojh.thinkit.repository.SubjectRepository;
import com.nojh.thinkit.vo.ConceptVO;
import com.nojh.thinkit.vo.KeywordVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class BaseService {
    private final ConceptRepository conceptRepository;
    private final KeywordRepository keywordRepository;
    private final SubjectRepository subjectRepository;
    private final ProblemRepository problemRepository;

    private final Map<String, Integer> subjects = Map.of(
            "dataStructure", 1
    );

    private final Map<String, Integer> keywords = Map.of(
            "array", 1
    );

    public KeywordVO getKeywords(String subject) {
        int id = subjects.get(subject);
        List<Keyword> list = keywordRepository.findBySubjectId(id);
        List<String> keyword_names = new ArrayList<>();
        KeywordVO keywordVO = new KeywordVO();

        for (Keyword keyword : list) {
            keyword_names.add(keyword.getName());
        }
        //keywordVO.setSubject_name(subject);
        keywordVO.setKeywords(keyword_names);
        return keywordVO;
    }

    public ConceptVO getConceptContent(String keyword){
        int id = keywords.get(keyword);
        Concept content = conceptRepository.findByKeywordId(id);
        ConceptVO conceptVO = new ConceptVO();
        conceptVO.setContent(content.getContent());
        return conceptVO;
    }
}
