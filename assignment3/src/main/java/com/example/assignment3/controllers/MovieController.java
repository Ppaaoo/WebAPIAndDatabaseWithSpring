package com.example.assignment3.controllers;

import com.example.assignment3.models.Movie;
import com.example.assignment3.services.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/movie")
public class MovieController {
    private final MovieService movieService;
    @GetMapping //http://localhost:8080/api/movie
    @ResponseStatus(value = HttpStatus.OK)
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{movie_id}") //http://localhost:8080/api/movie/{movie_id}
    @ResponseStatus(value = HttpStatus.FOUND)
    public Movie getMovieById(@PathVariable("movie_id") int id) {
        return movieService.getById(id);
    }

    @PostMapping("/add") //http://localhost:8080/api/movie/add
    @ResponseStatus(value = HttpStatus.CREATED)
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.addMovie(movie);
    }

    @DeleteMapping("/delete/{movie_id}") //http://localhost:8080/api/movie/delete/{movie_id}
    @ResponseStatus(value = HttpStatus.OK)
    public String deleteMovieById(@PathVariable("movie_id") int id) {
        movieService.deleteMovieById(id);
        return "Deleted movie with id: " + id;
    }

    @PatchMapping("/update/{movie_id}") //http://localhost:8080/api/movie/update/{movie_id}
    public String updateMovieById(@PathVariable("movie_id") int id, @RequestBody Movie movie) {
        movieService.updateMovieById(id, movie);
        return "Updated movie with id: " + movie.getId();
    }
}
