package com.movierental.model;

public class MovieRental {
    private String movieId;
    private int rentalDays;

    public MovieRental(String movieId, int rentalDays) {
        this.movieId = movieId;
        this.rentalDays = rentalDays;
    }

    public String getMovieId() {
        return movieId;
    }

    public int getRentalDays() {
        return rentalDays;
    }
}
