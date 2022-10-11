package com.nojh.thinkit.controller;

import com.nojh.thinkit.service.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BaseController {
    private final Map<String, Integer> subjects = Map.of(
            "dataStructure", 1);
    private final BaseService baseService;

    @GetMapping(value = "/keywords", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<String>> sendKeywords(@RequestParam("subject") String subject){
        int subject_id = subjects.get(subject);
        List<String> keywords = baseService.getKeywords(subject_id);
        return new ResponseEntity<>(keywords, HttpStatus.OK);
    }

    @GetMapping("/concepts")
    public void explanation(){

    }

    @GetMapping("/problems")
    public void problems(){

    }

    @GetMapping("/interview-problems")
    public void interview_problems(){

    }
}
