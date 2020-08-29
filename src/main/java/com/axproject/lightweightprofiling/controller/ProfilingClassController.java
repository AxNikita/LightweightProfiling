package com.axproject.lightweightprofiling.controller;

import com.axproject.lightweightprofiling.component.Profiling;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/class/profiling")
public class ProfilingClassController {

    @Autowired
    private Profiling profiling;

    @GetMapping("/")
    public String getClassProfilingMainPage(Model model) {
        return "profilingClass";
    }

    @GetMapping("/low")
    public String getLowProfiling(Model model) {
        try {
            profiling.lowProfiling();
        } catch (Exception e) {
            model.addAttribute("error", e);
        }
        return "profilingClass";
    }

    @GetMapping("/medium")
    public String getMediumProfiling(Model model) {
        try {
            profiling.mediumProfiling();
        } catch (Exception e) {
            model.addAttribute("error", e);
        }
        return "profilingClass";
    }

    @GetMapping("/hard")
    public String getHardProfiling(Model model) {
        try {
            profiling.hardProfiling();
        } catch (Exception e) {
            model.addAttribute("error", e);
        }
        return "profilingClass";
    }

}
