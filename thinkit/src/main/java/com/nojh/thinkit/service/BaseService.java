package com.nojh.thinkit.service;

import com.nojh.thinkit.dto.*;
import com.nojh.thinkit.entity.*;
import com.nojh.thinkit.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BaseService {
    private final ConceptRepository conceptRepository;
    private final KeywordRepository keywordRepository;
    private final SubjectRepository subjectRepository;
    private final ProblemRepository problemRepository;
    private final FeedbackRepository feedbackRepository;
    private final InterviewProblemRepository interviewProblemRepository;

    public KeywordDto getKeywords(String name) {
        Subject subject = subjectRepository.findByNameEquals(name);
        List<Keyword> list = keywordRepository.findBySubjectId(subject.getId());
        List<String> keyword_names = new ArrayList<>();
        list.forEach(keyword -> keyword_names.add(keyword.getName()));
        KeywordDto keywordDto = new KeywordDto(keyword_names);
        return keywordDto;
    }

    public ConceptDto getConceptContent(String name) {
        Keyword keyword = keywordRepository.findByNameEquals(name);
        Concept content = conceptRepository.findByKeywordId(keyword.getId());
        ConceptDto conceptDto = new ConceptDto(content.getContent());
        return conceptDto;
    }


    // TODO: 다형성을 위한 리팩토링을 할 것
    public ProblemDto getProblems(List<String> subjects) {
        List<Integer> ids = new ArrayList<>();
        int per_cnt = (int) (10 / subjects.size()) + 1;
        List<String> title_list = new ArrayList<>();
        List<String> content_list = new ArrayList<>();
        subjects.forEach(e -> {
            Subject subject = subjectRepository.findByNameEquals(e);
            ids.add(subject.getId());
        });

        ids.forEach(id -> {
            Optional<Subject> s = subjectRepository.findById(id);
            Subject sub;
            if (s.isPresent()) {
                sub = s.get();
                List<Problem> problems = problemRepository.selectByRandom(sub.getId(), per_cnt);
                problems.forEach(data -> {
                    title_list.add(data.getTitle());
                    content_list.add(data.getContent());
                });
            }
        });
        return new ProblemDto(title_list, content_list);
    }

    public InterviewProblemDto getInterviewProblems(List<String> subjects) {
        List<Integer> ids = new ArrayList<>();
        int per_cnt = (int) (10 / subjects.size()) + 1;
        List<String> content_list = new ArrayList<>();
        subjects.forEach(e -> {
            Subject subject = subjectRepository.findByNameEquals(e);
            ids.add(subject.getId());
        });

        ids.forEach(id -> {
            Optional<Subject> s = subjectRepository.findById(id);
            Subject sub;
            if (s.isPresent()) {
                sub = s.get();
                List<InterviewProblem> problems = interviewProblemRepository.selectByRandom(sub.getId(), per_cnt);
                problems.forEach(e->{
                    content_list.add(e.getContent());
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
