package com.movierental.main;

import com.movierental.constants.Constants;
import com.movierental.model.Customer;
import com.movierental.model.MovieRental;
import com.movierental.rentaldetail.RentalInfo;

import java.util.Arrays;
import java.util.logging.Logger;

public class Main {
    public static final Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {

        String result = new RentalInfo().getRentalDetails(new Customer(Constants.CUSTOMER_NAME, Arrays.asList(
                new MovieRental(Constants.MOV_1_ID, 3),
                new MovieRental(Constants.MOV_2_ID, 1))));

        if (!result.equals(Constants.RESULT_STR)) {
            throw new AssertionError("Expected: " + System.lineSeparator()
                    + String.format(Constants.CUSTOMER_NAME)
                    + System.lineSeparator() + System.lineSeparator()
                    + "Got: " + System.lineSeparator() + result);
        }

        log.info("Success");
    }
}
