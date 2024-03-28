package org.appiersign.services;

import org.appiersign.entities.Bill;
import org.appiersign.entities.Product;
import org.appiersign.entities.User;
import org.appiersign.enums.EUserType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This is a test class for FivePercentageForEveryHundredPolicy.java
 * It contains tests for the calculateDiscount() method.
 */
public class BulkDiscountPolicyTest {

    /**
     * Test calculateDiscount method when bill amount is more than 100
     */
    @Test
    public void testCalculateDiscount_BillAbove100() {
        BulkDiscountPolicy policy = new BulkDiscountPolicy();
        Bill bill = setupBillWithAmount(990.00);

        double result = policy.calculateDiscount(bill);
        assertEquals(result, 45);
    }

    /**
     * Test calculateDiscount method when bill amount is less than or equal 100
     */
    @Test
    public void testCalculateDiscount_BillBelow100() {
        BulkDiscountPolicy policy = new BulkDiscountPolicy();
        Bill bill = setupBillWithAmount(70.00);

        double result = policy.calculateDiscount(bill);
        assertEquals(result, 0);
    }

    /**
    * A method to setup a bill object with desired amount
    */
    private Bill setupBillWithAmount(double amount) {
        User user = new User(1L, "Solomon APPIER-SIGN", EUserType.EMPLOYEE, LocalDate.now());
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Product 1", amount, false));

        return new Bill(user, products);
    }
}