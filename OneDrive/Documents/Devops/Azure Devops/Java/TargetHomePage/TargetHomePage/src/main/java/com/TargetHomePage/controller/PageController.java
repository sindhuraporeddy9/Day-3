package com.TargetHomePage.controller;

import com.TargetHomePage.service.SampleDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    private final SampleDataService sampleDataService;

    public PageController(SampleDataService sampleDataService) {
        this.sampleDataService = sampleDataService;
    }

    @GetMapping("/about")
    public String about(Model model) {
        model.addAttribute("categories", sampleDataService.getCategories());
        return "about";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
        model.addAttribute("categories", sampleDataService.getCategories());
        return "contact";
    }
}
