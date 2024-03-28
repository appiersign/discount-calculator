package org.appiersign.entities;

public class Product {
    private Long id;
    private String name;
    private double price;
    private Boolean isGrocery;

    public Product(Long id, String name, double price, Boolean isGrocery) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.isGrocery = isGrocery;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean getIsGrocery() {
        return isGrocery;
    }

    public void setGrocery(Boolean grocery) {
        isGrocery = grocery;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", isGrocery=" + isGrocery +
                '}';
    }
}
