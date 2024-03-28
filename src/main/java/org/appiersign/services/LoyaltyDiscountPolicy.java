package org.appiersign.services;

import org.appiersign.entities.Bill;
import org.appiersign.entities.Product;
import org.appiersign.entities.User;
import org.appiersign.interfaces.DiscountPolicyInterface;

import java.util.List;

public class LoyaltyDiscountPolicy implements DiscountPolicyInterface {
    @Override
    public double calculateDiscount(Bill bill) {
        User user = bill.getUser();

        if (user.qualifiesForTwoYearsDiscount() && !user.hasPercentageDiscount()) {
            List<Product> products = bill.getProducts();
            return products.stream()
                    .filter(product -> !product.getIsGrocery())
                    .mapToDouble(Product::getPrice)
                    .sum() * 0.05;
        }
        return 0;
    }
}
