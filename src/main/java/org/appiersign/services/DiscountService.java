package org.appiersign.services;

import org.appiersign.entities.Bill;
import org.appiersign.interfaces.DiscountPolicyInterface;

import java.util.List;
import java.util.stream.DoubleStream;

/**
 * The DiscountService class provides methods for calculating discounts on a bill and net payable amount after applying discounts.
 */
public class DiscountService {
    private static List<DiscountPolicyInterface> getPolicies() {
        return List.of(
                new EmployeeDiscountPolicy(),
                new AffiliateDiscountPolicy(),
                new LoyaltyDiscountPolicy(),
                new BulkDiscountPolicy()
        );
    }

    /**
     * Calculates the net payable amount for a given bill, taking into account various discount policies.
     *
     * @param bill The bill object representing the user's purchase.
     * @return The net payable amount after applying discounts to the gross amount.
     */
    public static double calculateNetPayableAmount(Bill bill) {
        DoubleStream discounts = getPolicies()
                .stream()
                .map(policy -> policy.calculateDiscount(bill))
                .mapToDouble(Double::doubleValue);

        return bill.calculateTotalAmount() - discounts.sum();
    }
}
