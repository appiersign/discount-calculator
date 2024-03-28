package org.appiersign.services;

import org.appiersign.entities.Bill;
import org.appiersign.entities.Product;
import org.appiersign.enums.EUserType;
import org.appiersign.interfaces.DiscountPolicyInterface;

import java.util.List;

public class AffiliateDiscountPolicy implements DiscountPolicyInterface {

    @Override
    public double calculateDiscount(Bill bill) {
        if (bill.getUser().getType().equals(EUserType.AFFILIATE)) {
            List<Product> products = bill.getProducts();
            return products.stream()
                    .filter(product -> !product.getIsGrocery())
                    .mapToDouble(Product::getPrice)
                    .sum() * 0.1;
        }
        return 0;
    }
}
