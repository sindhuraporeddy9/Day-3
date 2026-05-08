package com.TargetHomePage.service;

import com.TargetHomePage.model.CartItem;
import com.TargetHomePage.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SampleDataService {

    private final List<Product> products = List.of(
            new Product(1, "Eco Essentials Tote", "Home", "Durable tote built for everyday errands.", 29.99, 4.8, "https://images.unsplash.com/photo-1512436991641-6745cdb1723f?auto=format&fit=crop&w=900&q=80", true),
            new Product(2, "Smart Kitchen Mixer", "Kitchen", "Powerful mixer with polished red accents.", 179.99, 4.6, "https://images.unsplash.com/photo-1603046891483-6b5c1ed4c825?auto=format&fit=crop&w=900&q=80", true),
            new Product(3, "Modern Sofa Throw", "Decor", "Soft woven throw to refresh any living room.", 49.99, 4.5, "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?auto=format&fit=crop&w=900&q=80", false),
            new Product(4, "Performance Running Shoes", "Fashion", "Lightweight trainers designed for comfort.", 89.99, 4.7, "https://images.unsplash.com/photo-1528701800489-180a8c30f3a0?auto=format&fit=crop&w=900&q=80", false),
            new Product(5, "Wireless Home Speaker", "Electronics", "Room-filling sound with premium finish.", 129.99, 4.9, "https://images.unsplash.com/photo-1503376780353-7e6692767b70?auto=format&fit=crop&w=900&q=80", true),
            new Product(6, "Outdoor Dining Set", "Garden", "Modern outdoor dining ready for summer.", 349.99, 4.4, "https://images.unsplash.com/photo-1505693416388-ac5ce068fe85?auto=format&fit=crop&w=900&q=80", false)
    );

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public List<Product> getFeaturedProducts() {
        return products.stream()
                .filter(Product::isFeatured)
                .collect(Collectors.toList());
    }

    public Product getProductById(int productId) {
        return products.stream()
                .filter(product -> product.getId() == productId)
                .findFirst()
                .orElse(null);
    }

    public List<String> getCategories() {
        return Arrays.asList("Home", "Kitchen", "Electronics", "Fashion", "Beauty", "Garden", "Toys", "Wellness");
    }

    public List<CartItem> getCartItems() {
        return List.of(
                new CartItem(products.get(0), 1),
                new CartItem(products.get(4), 2)
        );
    }
}
