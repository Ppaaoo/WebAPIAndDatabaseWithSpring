package com.example.assignment3.controllers;

import com.example.assignment3.mappers.MovieMapper;
import com.example.assignment3.models.Movie;
import com.example.assignment3.models.dto.MovieDto;
import com.example.assignment3.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/movie")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper;

    public MovieController(MovieService movieService, MovieMapper movieMapper) {
        this.movieService = movieService;
        this.movieMapper = movieMapper;
    }

    @GetMapping // GET: localhost:8080/api/v1/movie
    public ResponseEntity getAll() {
        Collection<MovieDto> movies = movieMapper.movieToMovieDto(
                movieService.findAll()
        );
        return ResponseEntity.ok(movies);
    }
}
