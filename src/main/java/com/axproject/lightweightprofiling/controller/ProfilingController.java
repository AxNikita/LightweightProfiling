package com.axproject.lightweightprofiling.controller;

import com.axproject.lightweightprofiling.component.Profiling;
import com.axproject.lightweightprofiling.component.ProfilingComponent;
import org.apache.catalina.core.ApplicationContext;
import org.apache.catalina.core.ApplicationContextFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfilingController {

    @Autowired
    private Profiling profiling;

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/profiling/low")
    public String getLowProfiling(Model model) {
        try {
            profiling.lowProfiling();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping("/profiling/medium")
    public String getMediumProfiling(Model model) {
        try {
            profiling.mediumProfiling();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

    @GetMapping("/profiling/hard")
    public String getHardProfiling(Model model) {
        try {
            profiling.hardProfiling();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index";
    }

}
