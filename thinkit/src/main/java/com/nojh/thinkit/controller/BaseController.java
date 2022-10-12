package com.nojh.thinkit.controller;

import com.nojh.thinkit.dto.ConceptDto;
import com.nojh.thinkit.dto.KeywordDto;
import com.nojh.thinkit.dto.ProblemDto;
import com.nojh.thinkit.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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

    /*@GetMapping("/problems")
    public void problems(@RequestParam("subjects") List<String> subjects) {
        ProblemDto problemDto = baseService.getProblems()
    }*/

    @GetMapping("/interview-problems")
    public void interview_problems() {

    }

    @GetMapping("/test")
    public ResponseEntity<ProblemDto> test(@RequestParam("subjects") List<String> subjects) {
        List<String> title = new ArrayList<>();
        List<String> content = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            title.add("문제" + i);
            String select = "";
            for (int j = 1; j <= 3; j++) {
                select += "보기" + i + "-" + j + ".";
            }
            select += "보기4";
            content.add(select);
        }
        ProblemDto problemDto = new ProblemDto(title, content);
        return new ResponseEntity<>(problemDto, HttpStatus.OK);
    }
}
