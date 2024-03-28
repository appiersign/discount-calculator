package org.appiersign.services;

import org.appiersign.entities.Bill;
import org.appiersign.entities.Product;
import org.appiersign.entities.User;
import org.appiersign.enums.EUserType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltyDiscountPolicyTest {

    /**
     * Calculates the discount for a bill when the user has no percentage discount and qualifies for the two-year discount.
     *
     */
    @Test
    void whenUserHasNoPercentDiscountAndQualifiesForTwoYearDiscount_calculateDiscount() {
        // prepare
        User user = new User(1L, "Solomon APPIER-SIGN", EUserType.CUSTOMER, LocalDate.now().minusYears(3));
        
        Product product = new Product(1L, "Storm energy drink", 100, false);
        Bill bill = new Bill(user, List.of(product));

        // execute
        LoyaltyDiscountPolicy loyaltyDiscountPolicy = new LoyaltyDiscountPolicy();
        double discount = loyaltyDiscountPolicy.calculateDiscount(bill);
        
        // verify
        assertEquals(5, discount);
    }

    /**
     * Calculates the discount for a bill when the user has a percentage discount of zero.
     * This method checks if the user has a percentage discount and returns zero as the discount value.
     *
     */
    @Test
    void whenUserHasPercentDiscount_calculateDiscountReturnsZero() {
        // prepare
        User user = new User(1L, "Solomon APPIER-SIGN", EUserType.EMPLOYEE, LocalDate.now());
        
        Product product = new Product(1L, "Medisoft Soap", 100.00, false);
        Bill bill = new Bill(user, List.of(product));

        // execute
        LoyaltyDiscountPolicy loyaltyDiscountPolicy = new LoyaltyDiscountPolicy();
        double discount = loyaltyDiscountPolicy.calculateDiscount(bill);
        
        // verify
        assertEquals(0, discount);
    }

    /**
     * Calculates the discount for a bill when the user does not qualify for a two-year discount.
     * This method checks if the user qualifies for the two-year discount and if the user does not have a percentage discount.
     * If the user meets these conditions, the method calculates the discount based on the sum of the prices of non-grocery products in the bill.
     * If the user does not meet these conditions, the method returns zero as the discount value.
     *
     */
    @Test
    void whenUserDoesNotQualifyForTwoYearDiscount_calculateDiscountReturnsZero() {
        // prepare
        User user = new User(1L, "Solomon APPIER-SIGN", EUserType.CUSTOMER, LocalDate.now().minusYears(1));
        
        Product product = new Product(1L, "Pepsodent Tooth brush", 100.00, false);
        Bill bill = new Bill(user, List.of(product));

        // execute
        LoyaltyDiscountPolicy loyaltyDiscountPolicy = new LoyaltyDiscountPolicy();
        double discount = loyaltyDiscountPolicy.calculateDiscount(bill);
        
        // verify
        assertEquals(0, discount);
    }
    
    /**
     * Calculates the discount for a bill when the product is a grocery item.
     * This method checks if the user qualifies for the two-year discount and does not have a percentage discount.
     * If the user meets these conditions, the method calculates the discount based on the sum of the prices of non-grocery products in the bill.
     * If the user does not meet these conditions, the method returns zero as the discount value.
     */
    @Test
    void whenProductIsGrocery_calculateDiscountReturnsZero() {
        // prepare
        User user = new User(1L, "Solomon APPIER-SIGN", EUserType.CUSTOMER, LocalDate.now().minusYears(3));
        
        Product product = new Product(1L, "Carnation Milk", 100.00, true);
        Bill bill = new Bill(user, List.of(product));

        // execute
        LoyaltyDiscountPolicy loyaltyDiscountPolicy = new LoyaltyDiscountPolicy();
        double discount = loyaltyDiscountPolicy.calculateDiscount(bill);
        
        // verify
        assertEquals(0, discount);
    }

    @Test
    void whenProductIsNotGrocery_calculateDiscountReturnsDiscount() {
        // prepare
        User user = new User(1L, "Solomon APPIER-SIGN", EUserType.CUSTOMER, LocalDate.now().minusYears(3));

        Product product = new Product(1L, "Airpods", 90.00, false);
        Bill bill = new Bill(user, List.of(product));

        // execute
        LoyaltyDiscountPolicy loyaltyDiscountPolicy = new LoyaltyDiscountPolicy();
        double discount = loyaltyDiscountPolicy.calculateDiscount(bill);

        // verify
        assertEquals(4.5, discount);
    }
}