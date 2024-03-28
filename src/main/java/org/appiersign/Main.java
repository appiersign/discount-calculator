package org.appiersign;

import org.appiersign.entities.Bill;
import org.appiersign.entities.Product;
import org.appiersign.entities.User;
import org.appiersign.enums.EUserType;
import org.appiersign.services.DiscountService;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        User user = new User(1L, "Valerie APPIER-SIGN", EUserType.CUSTOMER, LocalDate.now().minusYears(5));

        Product product1 = new Product(1L, "Ideal Milk", 10.00, true);
        Product product2 = new Product(2L, "Nivea Deodorant", 25.00, false);

        Bill bill = new Bill(user, List.of(product1, product2));
        System.out.println("Net Amount Payable: " + DiscountService.calculateNetPayableAmount(bill));
    }
}