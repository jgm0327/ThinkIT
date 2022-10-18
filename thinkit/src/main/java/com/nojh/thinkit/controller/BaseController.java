package com.nojh.thinkit.controller;

import com.nojh.thinkit.dto.*;
import com.nojh.thinkit.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BaseController {

    private final BaseService baseService;

    @GetMapping(value = "/keywords", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KeywordDto> sendKeywords(@RequestParam("subject") String subject) {
        KeywordDto keywordDto = baseService.getKeywords(subject);
        return new ResponseEntity<>(keywordDto, HttpStatus.OK);
    }

    @GetMapping("/concepts")
    public ResponseEntity<ConceptDto> explanation(@RequestParam("keyword") String keyword) {
        ConceptDto conceptDto = baseService.getConceptContent(keyword);
        return new ResponseEntity<>(conceptDto, HttpStatus.OK);
    }

    @GetMapping("/interview-problems")
    public ResponseEntity<InterviewProblemDto> interview_problems(@RequestParam("subjects") List<String> subjects) {
        InterviewProblemDto interviewProblemDto = baseService.getInterviewProblems(subjects);
        return new ResponseEntity<>(interviewProblemDto, HttpStatus.OK);
    }

    @GetMapping("/problems")
    public ResponseEntity<ProblemDto> test(@RequestParam("subjects") List<String> subjects) {
        ProblemDto problemDto = baseService.getProblems(subjects);
        return new ResponseEntity<>(problemDto, HttpStatus.OK);
    }

    @PostMapping("/feedback")
    public ResponseEntity<FeedbackDto> getFeedBack(@RequestParam("feedback") String content) {
        FeedbackDto feedbackDto = baseService.getFeedback(content);
        return new ResponseEntity<>(feedbackDto, HttpStatus.OK);
    }
}
