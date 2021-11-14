package com.movierental.constants;

public enum RentalMovies {
    YOU_HAV_GOT_MAIL("You've Got Mail", "F001", "regular"),
    MATRX("Matrix", "F002", "regular"),
    CARS("Cars", "F003", "childrens"),
    FAST_FUR_X("Fast & Furious X", "F004", "new");

    private final String movieTitle;
    private final String movieId;
    private final String movieCode;

    RentalMovies(String movieTitle, String moviedId, String movieCode) {
        this.movieTitle = movieTitle;
        this.movieId = moviedId;
        this.movieCode = movieCode;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public String getMovieId() {
        return movieId;
    }

    public String getMovieCode() {
        return movieCode;
    }
}
