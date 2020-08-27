package com.axproject.lightweightprofiling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProfilingController {

    @GetMapping("/")
    public String getMainPage(@RequestParam(name = "title") String title, Model model) {
        model.addAttribute(title);
        return "index";
    }

}
