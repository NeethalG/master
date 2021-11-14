package com.movierental.constants;


public class RentalMessages {

    //Expected result strings
    public static final String TEST_CUSTOMER_NAME = "C. U. Stomer";
    public static final String TEST_MOV_1_ID = "F001";
    public static final String TEST_MOV_2_ID = "F002";
    public static final String RESULT_STR = "Rental Record for C. U. Stomer\n" +
            "\tYou've Got Mail\t3.5\n\tMatrix\t2.0\n" +
            "Amount owed is 5.5\nYou earned 2 frequent points\n";
    public static final String SUCCESS_MSG = "Success";

    //Result messages
    public static final String NO_CUSTOMER_PRESENT = "No Customer Present";
    public static final String NO_RENTALS = "No Movie Rentals for Customer";
    public static final String RENTAL_RECORD_FOR_CUSTOMER = "Rental Record for %s\n";
    public static final String AMNT_OWED = "Amount owed is %s\n";
    public static final String FREQ_POINTS_EARNED = "You earned %s frequent points\n";
}
