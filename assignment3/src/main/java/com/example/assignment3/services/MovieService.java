package com.example.assignment3.services;

import com.example.assignment3.models.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> getAllMovies();

//    Optional<Movie> getMovieById(int id);

    Movie getById(int id);

    Movie addMovie(Movie movie);

    void deleteMovieById(int id);
}
