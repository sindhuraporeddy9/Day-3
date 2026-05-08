package com.TargetHomePage.controller;

import com.TargetHomePage.model.Product;
import com.TargetHomePage.service.SampleDataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ProductController {

    private final SampleDataService sampleDataService;

    public ProductController(SampleDataService sampleDataService) {
        this.sampleDataService = sampleDataService;
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("categories", sampleDataService.getCategories());
        model.addAttribute("products", sampleDataService.getAllProducts());
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productDetails(@PathVariable("id") int id, Model model) {
        Product product = sampleDataService.getProductById(id);
        if (product == null) {
            return "redirect:/products";
        }
        model.addAttribute("categories", sampleDataService.getCategories());
        model.addAttribute("product", product);
        return "product-detail";
    }
}
