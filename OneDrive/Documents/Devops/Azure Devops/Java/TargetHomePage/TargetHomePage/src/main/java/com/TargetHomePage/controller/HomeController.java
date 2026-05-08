package com.TargetHomePage.controller;

import com.TargetHomePage.service.SampleDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final SampleDataService sampleDataService;

    public HomeController(SampleDataService sampleDataService) {
        this.sampleDataService = sampleDataService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {
        model.addAttribute("categories", sampleDataService.getCategories());
        model.addAttribute("featuredDeals", sampleDataService.getFeaturedProducts());
        model.addAttribute("products", sampleDataService.getAllProducts());
        return "index";
    }
}
