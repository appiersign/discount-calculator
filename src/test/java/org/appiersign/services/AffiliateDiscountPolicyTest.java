package org.appiersign.services;

import org.appiersign.entities.Bill;
import org.appiersign.entities.Product;
import org.appiersign.entities.User;
import org.appiersign.enums.EUserType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AffiliateDiscountPolicyTest {
    /**
     * AffiliateDiscountPolicyTest class is designed to test the behavior of the AffiliateDiscountPolicy class.
     * The 'calculateDiscount' method is especially crucial to ensure the correct discount is calculated based on the affiliate user type.
     */

    @Test
    public void testCalculateDiscountForAffiliate() {
        // Setup
        AffiliateDiscountPolicy policy = new AffiliateDiscountPolicy();

        User user = new User(1L, "Solomon APPIER-SIGN", EUserType.AFFILIATE, LocalDate.now());
        
        Product p1 = new Product(1L, "Book", 50.0, false);
        Product p2 = new Product(2L, "Groceries", 100.0, true);

        Bill bill = new Bill(user, Arrays.asList(p1, p2));

        // Exercise
        double discount = policy.calculateDiscount(bill);

        // Verify
        assertEquals(50.0*0.1, discount, "Discount should be 10% of non-grocery item total for affiliate users");
    }

    @Test
    public void testCalculateDiscountForNonAffiliate() {
        // Setup
        AffiliateDiscountPolicy policy = new AffiliateDiscountPolicy();

        User user = new User(1L, "Solomon APPIER-SIGN", EUserType.CUSTOMER, LocalDate.now());
        
        Product p1 = new Product(1L, "Book", 50.0, false);
        Product p2 = new Product(2L, "Groceries", 100.0, true);

        Bill bill = new Bill(user, Arrays.asList(p1, p2));

        // Exercise
        double discount = policy.calculateDiscount(bill);

        // Verify
        assertEquals(0.0, discount, "Discount should be 0 for non-affiliate users");
    }
}