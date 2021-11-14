package com.movierental.rentaldetail;

import com.movierental.constants.Constants;
import com.movierental.constants.RentalMovies;
import com.movierental.model.Customer;
import com.movierental.model.Movie;
import com.movierental.model.MovieRental;

import java.util.HashMap;
import java.util.Map;

public class RentalInfo {


    public String getRentalDetails(Customer customer) {

        if (null == customer) return "No Customer Present";
        if (null == customer.getRentals()) return "No Movie Rentals for Customer";
        // build the movie map
        Map<String, Movie> movies = buildMovieDetailsMap();

        double totalAmount = 0;
        int frequentEnterPoints = 0;
        StringBuilder resultBuilder = new StringBuilder();
        resultBuilder.append("Rental Record for " + customer.getName() + "\n");

        for (MovieRental r : customer.getRentals()) {
            double thisAmount = 0;
            String movieCode = movies.get(r.getMovieId()).getCode();
            String movieTitle = movies.get(r.getMovieId()).getTitle();
            int numDays = r.getDays();

            thisAmount = findTotalAmountForMovie(movieCode, numDays);

            //add frequent bonus points
            frequentEnterPoints++;
            // add bonus for a two day new release rental
            if (Constants.CODE_NEW.equals(movieCode) && numDays > 2) frequentEnterPoints++;


            //print figures for this rental
            resultBuilder.append("\t" + movieTitle + "\t" + thisAmount + "\n");
            totalAmount = totalAmount + thisAmount;
        }
        // add footer lines
        resultBuilder.append("Amount owed is " + totalAmount + "\n");
        resultBuilder.append("You earned " + frequentEnterPoints + " frequent points\n");

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
        if (Constants.CODE_REGULAR.equals(movieCode)) {
            amount = numDays > 2 ? ((numDays - 2) * 1.5) + Constants.AMNT_REG : Constants.AMNT_REG;
        } else if (Constants.CODE_CHILDRENS.equals(movieCode)) {
            amount = numDays > 3 ? ((numDays - 3) * 1.5) + Constants.AMNT_CHLDRNS : Constants.AMNT_CHLDRNS;
        } else if (Constants.CODE_NEW.equals(movieCode)) {
            amount = numDays * Constants.AMNT_NEW;
        }
        return amount;
    }

}
