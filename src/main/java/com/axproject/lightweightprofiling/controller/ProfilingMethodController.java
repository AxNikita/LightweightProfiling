package com.axproject.lightweightprofiling.controller;

import com.axproject.lightweightprofiling.component.ProfilingMethods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/method/profiling")
public class ProfilingMethodController {

    @Autowired
    private ProfilingMethods profilingMethods;

    @GetMapping("/")
    public String getMethodProfilingMainPage(Model model) {
        return "profilingMethod";
    }

    @GetMapping("/low")
    public String getLowProfiling(Model model) {
        try {
            profilingMethods.lowProfiling();
        } catch (Exception e) {
            model.addAttribute("error", e);
        }
        return "profilingMethod";
    }

    @GetMapping("/medium")
    public String getMediumProfiling(Model model) {
        try {
            profilingMethods.mediumProfiling();
        } catch (Exception e) {
            model.addAttribute("error", e);
        }
        return "profilingMethod";
    }

    @GetMapping("/hard")
    public String getHardProfiling(Model model) {
        try {
            profilingMethods.hardProfiling();
        } catch (Exception e) {
            model.addAttribute("error", e);
        }
        return "profilingMethod";
    }

}
