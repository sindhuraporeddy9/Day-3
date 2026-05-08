package com.TargetHomePage.controller;

import com.TargetHomePage.service.CartService;
import com.TargetHomePage.service.SampleDataService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CartController {

    private final SampleDataService sampleDataService;
    private final CartService cartService;

    public CartController(SampleDataService sampleDataService, CartService cartService) {
        this.sampleDataService = sampleDataService;
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String cart(Model model, HttpSession session) {
        model.addAttribute("categories", sampleDataService.getCategories());
        model.addAttribute("cartItems", cartService.getCart(session));
        model.addAttribute("cartTotal", cartService.getCartTotal(session));
        return "cart";
    }

    @GetMapping("/cart/add/{id}")
    public String addToCart(@PathVariable("id") int id, HttpSession session) {
        var product = sampleDataService.getProductById(id);
        if (product != null) {
            cartService.addProduct(session, product);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart/remove/{id}")
    public String removeFromCart(@PathVariable("id") int id, HttpSession session) {
        cartService.removeProduct(session, id);
        return "redirect:/cart";
    }
}
