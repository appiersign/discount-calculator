package org.appiersign.interfaces;

import org.appiersign.entities.Bill;

public interface DiscountPolicyInterface {
    double calculateDiscount(Bill bill);
}
