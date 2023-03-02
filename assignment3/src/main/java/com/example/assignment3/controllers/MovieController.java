package com.example.assignment3.controllers;

import com.example.assignment3.models.Movie;
import com.example.assignment3.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movie_id}")
    public Movie getMovieById(@PathVariable("movie_id") int id) {
        return movieService.getById(id);
    }

    @PostMapping("/add")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @DeleteMapping("/delete/{movie_id}")
    public String deleteMovieById(@PathVariable("movie_id") int id) {
        movieService.deleteMovieById(id);
        return "Movie delete";
    }
}
