package com.nojh.thinkit.service;

import com.nojh.thinkit.dto.*;
import com.nojh.thinkit.entity.*;
import com.nojh.thinkit.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class BaseService {
    private final ConceptRepository conceptRepository;
    private final KeywordRepository keywordRepository;
    private final SubjectRepository subjectRepository;
    private final ProblemRepository problemRepository;
    private final FeedbackRepository feedbackRepository;
    private final InterviewProblemRepository interviewProblemRepository;

    private final Map<String, Integer> subjects = Map.of(
            "dataStructure", 1
    );

    private final Map<String, Integer> keywords = Map.of(
            "array", 1
    );

    public KeywordDto getKeywords(String subject) {
        int id = subjects.get(subject);
        List<Keyword> list = keywordRepository.findBySubjectId(id);
        List<String> keyword_names = new ArrayList<>();

        for (Keyword keyword : list) {
            keyword_names.add(keyword.getName());
        }
        KeywordDto keywordDto = new KeywordDto(keyword_names);
        return keywordDto;
    }

    public ConceptDto getConceptContent(String keyword) {
        int id = keywords.get(keyword);
        Concept content = conceptRepository.findByKeywordId(id);
        ConceptDto conceptDto = new ConceptDto(content.getContent());
        return conceptDto;
    }

    public List<Integer> getRandomId(int per_cnt) {
        Map<Integer, Integer> map = new HashMap<>();
        int length = problemRepository.findAll().size();
        Random random = new Random();
        int cnt = 0;
        while (per_cnt > cnt) {
            int randomNum = random.nextInt(length - 1) + 1;
            if (map.get(randomNum) != null)
                continue;
            map.put(randomNum, 1);
            cnt++;
        }
        return map.keySet().stream().toList();
    }

    // TODO: 다형성을 위한 리팩토링을 할 것
    public ProblemDto getProblems(List<String> subjects) {
        List<Integer> ids = new ArrayList<>();
        int total = subjects.size(), per_cnt = (int) 10 / total;
        List<String> title_list = new ArrayList<>();
        List<String> content_list = new ArrayList<>();
        subjects.forEach(e -> {
            ids.add(this.subjects.get(e));
        });

        ids.forEach(id -> {
            Optional<Subject> s = subjectRepository.findById(id);
            Subject sub;
            if (s.isPresent()) {
                sub = s.get();
                List<Integer> list = getRandomId(per_cnt);
                list.forEach(e -> {
                    Problem problem = problemRepository.findBySubjectAndId(sub, e);
                    title_list.add(problem.getTitle());
                    content_list.add(problem.getContent());

                });
            }
        });
        return new ProblemDto(title_list, content_list);
    }

    public InterviewProblemDto getInterviewProblems(List<String> subjects) {
        List<Integer> ids = new ArrayList<>();
        int per_cnt = (int) 10 / subjects.size();
        List<String> content_list = new ArrayList<>();
        subjects.forEach(e -> {
            ids.add(this.subjects.get(e));
        });

        ids.forEach(id -> {
            Optional<Subject> s = subjectRepository.findById(id);
            Subject sub;
            if (s.isPresent()) {
                sub = s.get();
                List<Integer> list = getRandomId(per_cnt);
                list.forEach(e -> {
                    InterviewProblem problem = interviewProblemRepository.findBySubjectAndId(sub, e);
                    content_list.add(problem.getContent());
                });
            }
        });
        return new InterviewProblemDto(content_list);
    }

    public FeedbackDto getFeedback(String content) {
        Feedback feedback = new Feedback(content);
        feedbackRepository.save(feedback);
        return new FeedbackDto(true);
    }
}
