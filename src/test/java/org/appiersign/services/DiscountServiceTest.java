package org.appiersign.services;

import org.appiersign.entities.Bill;
import org.appiersign.entities.Product;
import org.appiersign.entities.User;
import org.appiersign.enums.EUserType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This class tests the calculateGrossPayableAmount method in DiscountService class.
 */
public class DiscountServiceTest {

    /**
     * Test to check if method calculateNetPayableAmount in DiscountService class
     * correctly calculates the total net amount of purchased products.
     */
    @Test
    public void testCalculateNetPayableAmount() {
        // Prepare test data
        User user = new User(1L, "Valerie APPIER-SIGN", EUserType.EMPLOYEE, LocalDate.now());

        Product product1 = new Product(1L, "Ideal Milk", 10.00, true);
        Product product2 = new Product(2L, "Nivea Deodorant", 25.00, false);

        Bill bill = new Bill(user, List.of(product1, product2));

        // Invoke the method to test
        double result = DiscountService.calculateNetPayableAmount(bill);

        // Assert the result
        assertEquals(27.50, result);
    }
}