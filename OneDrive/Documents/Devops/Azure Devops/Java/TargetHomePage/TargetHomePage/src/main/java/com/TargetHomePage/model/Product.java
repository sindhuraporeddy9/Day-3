package com.TargetHomePage.model;

public class Product {
    private final int id;
    private final String name;
    private final String category;
    private final String description;
    private final double price;
    private final double rating;
    private final String imageUrl;
    private final boolean featured;

    public Product(int id, String name, String category, String description, double price, double rating, String imageUrl, boolean featured) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
        this.rating = rating;
        this.imageUrl = imageUrl;
        this.featured = featured;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public double getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public boolean isFeatured() {
        return featured;
    }
}
