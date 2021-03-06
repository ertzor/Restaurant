package com.example.govert.restaurant;

import java.io.Serializable;

public class MenuItem implements Serializable {
    private String name;
    private String description;
    private String imageURL;
    private String price;
    private String category;

    public MenuItem(String name, String description, String imageURL, String price, String category) {
        this.name = name;
        this.description = description;
        this.imageURL = imageURL;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
