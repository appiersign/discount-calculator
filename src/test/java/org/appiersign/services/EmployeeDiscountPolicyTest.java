package org.appiersign.services;

import org.appiersign.entities.User;
import org.appiersign.entities.Product;
import org.appiersign.interfaces.DiscountPolicyInterface;
import org.appiersign.enums.EUserType;
import org.appiersign.entities.Bill;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Arrays;

public class EmployeeDiscountPolicyTest {

    /**
     * This method is a unit test for the calculateDiscountForEmployeeWithNonGroceryItems method in the EmployeeDiscountPolicy class.
     * It tests whether the discount calculation for an employee with non-grocery items in the bill is correct.
     * <p>
     * The test case performs the following steps:
     * 1. Creates two non-grocery items with their respective IDs, names, prices, and grocery flags.
     * 2. Creates a user object with the ID, name, user type ("EMPLOYEE"), and today's date.
     * 3. Creates a bill object with the created user and the list of non-grocery items.
     * 4. Creates an instance of the EmployeeDiscountPolicy class.
     * 5. Calls the calculateDiscount method of the EmployeeDiscountPolicy class, passing the bill object as an argument.
     * 6. Asserts that the calculated discount is equal to 90.
     *
     * @see EmployeeDiscountPolicy
     * @see Product
     * @see User
     * @see Bill
     * @see EUserType
     */
    @Test
    public void testCalculateDiscountForEmployeeWithNonGroceryItems() {
        // Arrange
        Product product1 = new Product(1L, "non-grocery item", 100.0, false);
        Product product2 = new Product(2L, "non-grocery item", 200.0, false);

        User user = new User(1L, "Solomon APPIER-SIGN", EUserType.EMPLOYEE, LocalDate.now());
        Bill bill = new Bill(user, Arrays.asList(product1, product2));

        DiscountPolicyInterface discountPolicyInterface = new EmployeeDiscountPolicy();

        // Act
        double discount = discountPolicyInterface.calculateDiscount(bill);

        // Assert
        assertEquals(90, discount); 
    }

    /**
     * This method is a unit test for the calculateDiscountForEmployeeWithGroceryItems method in the EmployeeDiscountPolicy class.
     * It tests whether the discount calculation for an employee with grocery items in the bill is correct.
     * <p>
     * The test case performs the following steps:
     * 1. Creates two grocery items with their respective IDs, names, prices, and grocery flags.
     * 2. Creates a user object with the ID, name, user type ("EMPLOYEE"), and today's date.
     * 3. Creates a bill object with the created user and the list of grocery items.
     * 4. Creates an instance of the EmployeeDiscountPolicy class.
     * 5. Calls the calculateDiscount method of the EmployeeDiscountPolicy class, passing the bill object as an argument.
     * 6. Asserts that the calculated discount is equal to 0.
     *
     * @see EmployeeDiscountPolicy
     * @see Product
     * @see User
     * @see Bill
     * @see EUserType
     */
    @Test
    public void testCalculateDiscountForEmployeeWithGroceryItems() {
        // Arrange
        Product product1 = new Product(1L, "grocery item", 100.0, true);
        Product product2 = new Product(2L, "grocery item", 200.0, true);

        User user = new User(1L, "Solomon APPIER-SIGN", EUserType.EMPLOYEE, LocalDate.now());
        Bill bill = new Bill(user, Arrays.asList(product1, product2));

        DiscountPolicyInterface discountPolicyInterface = new EmployeeDiscountPolicy();

        // Act
        double discount = discountPolicyInterface.calculateDiscount(bill);

        // Assert
        assertEquals(0, discount);
    }


    @Test
    public void testCalculateDiscountForEmployeeForNonEmployees() {
        // Arrange
        Product product1 = new Product(1L, "grocery item", 100.0, true);
        Product product2 = new Product(2L, "grocery item", 200.0, true);

        User user = new User(1L, "Solomon APPIER-SIGN", EUserType.CUSTOMER, LocalDate.now());
        Bill bill = new Bill(user, Arrays.asList(product1, product2));

        DiscountPolicyInterface discountPolicyInterface = new EmployeeDiscountPolicy();

        // Act
        double discount = discountPolicyInterface.calculateDiscount(bill);

        // Assert
        assertEquals(0, discount);
    }
}