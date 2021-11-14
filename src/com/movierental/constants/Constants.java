package com.movierental.constants;


public class Constants {
    // movie codes
    public static final String CODE_REGULAR = "regular";
    public static final String CODE_CHILDRENS = "childrens";
    public static final String CODE_NEW = "new";

    //movie amount based on code
    public static final double AMNT_REG = 2.0;
    public static final double AMNT_CHLDRNS = 1.5;
    public static final double AMNT_NEW = 3.0;

    //Expected result strings
    public static final String CUSTOMER_NAME = "C. U. Stomer";
    public static final String MOV_1_ID = "F001";
    public static final String MOV_2_ID = "F002";
    public static final String RESULT_STR = "Rental Record for C. U. Stomer\n" +
                                                "\tYou've Got Mail\t3.5\n\tMatrix\t2.0\n" +
                                                "Amount owed is 5.5\nYou earned 2 frequent points\n";


}
