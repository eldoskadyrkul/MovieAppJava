package com.company.model;

import javax.swing.text.Style;

public class MovieModel {

    /* this is model components */
    private int IDMovie;
    private String movieTitle;
    private String ratingMovie;
    private String typesMovie;
    private int yearMovie;
    private int runtimeMovie;

    /* Constructor for films */

    public MovieModel(int movieID, String movieTitle, String ratingMovie, String typesMovie, int yearMovie, int runtimeMovie) {
        this.IDMovie = movieID;
        this.movieTitle = movieTitle;
        this.ratingMovie = ratingMovie;
        this.typesMovie = typesMovie;
        this.yearMovie = yearMovie;
        this.runtimeMovie = runtimeMovie;
    }

    public MovieModel(int movieID, String typesMovie) {
        this.IDMovie = movieID;
        this.typesMovie = typesMovie;
    }

    public MovieModel() {}

    /* Getter and Setter */

    public int getIDMovie() {
        return IDMovie;
    }

    public void setIDMovie(int IDMovie) {
        this.IDMovie = IDMovie;
    }

    public String getMovieTitle() {
        return movieTitle;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public String getRatingMovie() {
        return ratingMovie;
    }

    public void setRatingMovie(String ratingMovie) {
        this.ratingMovie = ratingMovie;
    }

    public String getTypesMovie() {
        return typesMovie;
    }

    public void setTypesMovie(String typesMovie) {
        this.typesMovie = typesMovie;
    }

    public int getYearMovie() {
        return yearMovie;
    }

    public void setYearMovie(int yearMovie) {
        this.yearMovie = yearMovie;
    }

    public int getRuntimeMovie() {
        return runtimeMovie;
    }

    public void setRuntimeMovie(int runtimeMovie) {
        this.runtimeMovie = runtimeMovie;
    }

    /* toString() methods */

    @Override
    public String toString() {
        return String.format("\n ID: %d" +
                "\n Movie title: %s" +
                "\n Rating: %s" +
                "\n Movie types: %s" +
                "\n Year: %d" +
                "\n Total runtime: %d", IDMovie, movieTitle, ratingMovie, typesMovie, yearMovie, runtimeMovie);
    }
}
