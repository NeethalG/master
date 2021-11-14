package com.movierental.rentaldetail;

import com.movierental.constants.MovieCode;
import com.movierental.constants.RentalMessages;
import com.movierental.constants.RentalMovies;
import com.movierental.model.Customer;
import com.movierental.model.Movie;
import com.movierental.model.MovieRental;

import java.util.HashMap;
import java.util.Map;

public class RentalInfo {


    public String getRentalDetails(Customer customer) {

        if (null == customer) return RentalMessages.NO_CUSTOMER_PRESENT;
        if (null == customer.getMovieRentals()) return RentalMessages.NO_RENTALS;
        // build the movie map
        Map<String, Movie> movies = buildMovieDetailsMap();

        double totalAmount = 0;
        int frequentEnterPoints = 0;
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append(String.format(RentalMessages.RENTAL_RECORD_FOR_CUSTOMER, customer.getName()));

        for (MovieRental r : customer.getMovieRentals()) {
            double thisAmount = 0;
            String movieCode = movies.get(r.getMovieId()).getCode();
            String movieTitle = movies.get(r.getMovieId()).getTitle();
            int numDays = r.getRentalDays();

            thisAmount = findTotalAmountForMovie(movieCode, numDays);

            //add frequent bonus points
            frequentEnterPoints++;
            // add bonus for a two day new release rental
            if (MovieCode.NEW.getCode().equals(movieCode) && numDays > 2) frequentEnterPoints++;


            //print figures for this rental
            resultBuilder.append("\t" + movieTitle + "\t" + thisAmount + "\n");
            totalAmount = totalAmount + thisAmount;
        }
        // add footer lines
        resultBuilder.append(String.format(RentalMessages.AMNT_OWED, totalAmount));
        resultBuilder.append(String.format(RentalMessages.FREQ_POINTS__EARNED, frequentEnterPoints));

        return resultBuilder.toString();
    }

    public Map<String, Movie> buildMovieDetailsMap() {
        Map<String, Movie> movieHashMap = new HashMap<>();
        for (RentalMovies movie : RentalMovies.values()) {
            movieHashMap.put(movie.getMovieId(), new Movie(movie.getMovieTitle(), movie.getMovieCode()));
        }
        return movieHashMap;
    }

    public double findTotalAmountForMovie(String movieCode, int numDays) {
        double amount = 0;
        // determine amount for each movie
        if (MovieCode.REGULAR.getCode().equals(movieCode)) {
            amount = numDays > 2 ? ((numDays - 2) * 1.5) + MovieCode.REGULAR.getBaseRent()
                    : MovieCode.REGULAR.getBaseRent();
        } else if (MovieCode.CHILDRENS.getCode().equals(movieCode)) {
            amount = numDays > 3 ? ((numDays - 3) * 1.5) + MovieCode.CHILDRENS.getBaseRent()
                    : MovieCode.CHILDRENS.getBaseRent();
        } else if (MovieCode.NEW.getCode().equals(movieCode)) {
            amount = numDays * MovieCode.NEW.getBaseRent();
        }
        return amount;
    }

}
