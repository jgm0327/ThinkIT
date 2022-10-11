package com.nojh.thinkit.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nojh.thinkit.service.BaseService;
import com.nojh.thinkit.vo.ConceptVO;
import com.nojh.thinkit.vo.KeywordVO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BaseController {

    private final BaseService baseService;

    @GetMapping(value = "/keywords", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<KeywordVO> sendKeywords(@RequestParam("subject") String subject){
        KeywordVO keywordVO = baseService.getKeywords(subject);
        return new ResponseEntity<>(keywordVO, HttpStatus.OK);
    }

    @GetMapping("/concepts")
    public ResponseEntity<ConceptVO> explanation(@RequestParam("keyword") String keyword){
        ConceptVO conceptVO = baseService.getConceptContent(keyword);
        return new ResponseEntity<>(conceptVO, HttpStatus.OK);
    }

    @GetMapping("/problems")
    public void problems(){

    }

    @GetMapping("/interview-problems")
    public void interview_problems(){

    }
}
