package com.movierental.model;

import java.util.List;

public class Customer {
    private String name;
    private List<MovieRental> movieRentals;

    public Customer(String name, List<MovieRental> movieRentals) {
        this.name = name;
        this.movieRentals = movieRentals;
    }

    public String getName() {
        return name;
    }

    public List<MovieRental> getMovieRentals() {
        return movieRentals;
    }
}
