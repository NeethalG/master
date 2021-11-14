package com.movierental.rentaldetail;

import com.movierental.constants.RentalMessages;
import com.movierental.model.Customer;
import com.movierental.model.MovieRental;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RentalInfoTest {

    @Test
    public void testCustomer_null() {
        String result = new RentalInfo().getRentalDetails(null);
        assertEquals(RentalMessages.NO_CUSTOMER_PRESENT, result);
    }

    @Test
    public void testCustomer_null_rentals() {
        String result = new RentalInfo().getRentalDetails(new Customer("testCustomer", null));
        assertEquals(RentalMessages.NO_RENTALS, result);
    }

    @Test
    public void testCustomer_1() {
        String result = new RentalInfo().getRentalDetails(new Customer("C. U. Stomer", Arrays.asList(
                new MovieRental("F001", 3),
                new MovieRental("F002", 1))));
        assertEquals(result, "Rental Record for C. U. Stomer\n" +
                "\tYou've Got Mail\t3.5\n\tMatrix\t2.0\n" +
                "Amount owed is 5.5\nYou earned 2 frequent points\n");
    }

    @Test
    public void testCustomer_2() {
        String result = new RentalInfo().getRentalDetails(new Customer("Peter", Arrays.asList(
                new MovieRental("F001", 1),
                new MovieRental("F002", 1))));
        assertEquals(result, "Rental Record for Peter\n" +
                "\tYou've Got Mail\t2.0\n\tMatrix\t2.0\n" +
                "Amount owed is 4.0\nYou earned 2 frequent points\n");
    }

    @Test
    public void testCustomer_3() {
        String result = new RentalInfo().getRentalDetails(new Customer("Sam", Arrays.asList(
                new MovieRental("F003", 5),
                new MovieRental("F004", 3))));
        assertEquals(result, "Rental Record for Sam\n" +
                "\tCars\t4.5\n\tFast & Furious X\t9.0\n" +
                "Amount owed is 13.5\nYou earned 3 frequent points\n");
    }

    @Test
    public void testCustomer_4() {
        String result = new RentalInfo().getRentalDetails(new Customer("Lilly", Arrays.asList(
                new MovieRental("F003", 5))));
        assertEquals(result, "Rental Record for Lilly\n" +
                "\tCars\t4.5\n" +
                "Amount owed is 4.5\nYou earned 1 frequent points\n");
    }
}
