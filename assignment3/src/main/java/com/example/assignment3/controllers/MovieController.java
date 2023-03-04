package com.example.assignment3.controllers;

import com.example.assignment3.mappers.MovieMapper;
import com.example.assignment3.models.Movie;
import com.example.assignment3.models.dto.MovieDto;
import com.example.assignment3.services.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
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

    @GetMapping("/id/{id}") // GET: localhost:8080/api/v1/movie/id/1
    public ResponseEntity getById(@PathVariable int id) {
        MovieDto movie = movieMapper.movieToMovieDto(
                movieService.findById(id)
        );
        return ResponseEntity.ok(movie);
    }

    // TODO: look at later
    @GetMapping("/search") //GET: localhost:8080/api/v1/movie/search?name=Thor
    public ResponseEntity<Collection<Movie>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(movieService.findAllByName(name));
    }

    // TODO: make sure setting franchise and characters work
    @PostMapping // POST: localhost:8080/api/v1/movie
    public ResponseEntity addMovie(@RequestBody Movie movie) {
        Movie mov = movieService.add(movie);
        URI location = URI.create("movie/" + mov.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}") // PUT: localhost:8080/api/v1/movie/1
    public ResponseEntity update(@RequestBody MovieDto movieDto, @PathVariable int id) {
        if (id != movieDto.getId()) {
            return ResponseEntity.badRequest().build();
        }
        movieService.update(
                movieMapper.movieDtoToMovie(movieDto)
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/movie/1
    public ResponseEntity delete(@PathVariable int id) {
        Movie movie = movieService.findById(id);
        movie.setTitle(null);
        movie.setGenre(null);
        movie.setReleaseYear(0);
        movie.setDirector(null);
        movie.setPosterURL(null);
        movie.setTrailerURL(null);
        movie.setCharacters(null);
        movie.setFranchise(null);
        System.out.println(movie);
        movieService.update(movie);
        //movieService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
