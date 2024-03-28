package org.appiersign.entities;

import java.util.List;
import java.util.Objects;

public class Bill {
    private User user;
    private List<Product> products;

    public Bill(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Long productId) {
        setProducts(this.products.stream().filter(product -> !Objects.equals(product.getId(), productId)).toList());
    }

    public double calculateTotalAmount() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    private void setProducts(List<Product> products) {
        this.products = products;
    }
}
