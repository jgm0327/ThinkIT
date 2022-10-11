package com.nojh.thinkit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseViewController {
    @GetMapping(value="/concepts")
    public String explanation(@RequestParam("keyword") String keyword){
        return "test";
    }
}
