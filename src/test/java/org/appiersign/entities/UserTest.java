package org.appiersign.entities;

import org.appiersign.entities.User;
import org.appiersign.enums.EUserType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the User class
 * This class contains tests for the hasPercentageDiscount method
 */
public class UserTest {
    /**
     * Test for hasPercentageDiscount method
     * Test case: User is an employee
     */
    @Test
    public void hasPercentageDiscount_Employee_True() {
        User user = new User(1L, "John Doe", EUserType.EMPLOYEE, LocalDate.now());
        assertTrue(user.hasPercentageDiscount());
    }

    /**
     * Test for hasPercentageDiscount method
     * Test case: User is an affiliate
     */
    @Test
    public void hasPercentageDiscount_Affiliate_True() {
        User user = new User(2L, "Jane Doe", EUserType.AFFILIATE, LocalDate.now());
        assertTrue(user.hasPercentageDiscount());
    }

    /**
     * Test for hasPercentageDiscount method
     * Test case: User is a customer
     */
    @Test
    public void hasPercentageDiscount_Customer_False() {
        User user = new User(3L, "Bob Smith", EUserType.CUSTOMER, LocalDate.now());
        assertFalse(user.hasPercentageDiscount());
    }

    /**
     * 'Qualifies for a Two-Year Discount' test with existing user registration for over 2 years.
     * The User object with type EMPLOYEE is instantiated with the date of creation being set over 2 years ago,
     * and qualifying for the discount.
     */
    @Test
    public void shouldBeQualifyForTwoYearDiscountWithUserOver2Years() {
        User user = new User(1L, "John Doe", EUserType.CUSTOMER,
                LocalDate.now().minusYears(3));
        assertTrue(user.qualifiesForTwoYearsDiscount());
    }

    /**
     * 'Does Not Qualify for a Two-Year Discount' test with existing user registration under 2 years.
     * The User object with type EMPLOYEE is instantiated with the date of creation being set under 2 years,
     * and not qualifying for the discount.
     */
    @Test
    public void shouldNotBeQualifyForTwoYearDiscountWithUserUnder2Years() {
        User user = new User(2L, "Jane Doe", EUserType.EMPLOYEE,
                LocalDate.now().minusYears(1));
        assertFalse(user.qualifiesForTwoYearsDiscount());
    }
}