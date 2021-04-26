package com.example.ongiuaki;

public class Item {
    private int img;
    private String name;
    private double price;
    private String description;

    public Item() {
    }

    public Item(int img, String name, double price, String description) {

        this.img = img;
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
