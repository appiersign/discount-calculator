package org.appiersign.services;

import org.appiersign.entities.Bill;
import org.appiersign.entities.Product;
import org.appiersign.interfaces.DiscountPolicyInterface;

import java.util.List;

public class BulkDiscountPolicy implements DiscountPolicyInterface {
    @Override
    public double calculateDiscount(Bill bill) {
        List<Product> products = bill.getProducts();
        double billAmount = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();

        if (billAmount > 100.00) {
            double factor = Math.floor(billAmount / 100);
            return factor * 5;
        }

        return 0;
    }
}
