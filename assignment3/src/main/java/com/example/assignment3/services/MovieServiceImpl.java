package com.example.assignment3.services;

import com.example.assignment3.exceptions.NotFound;
import com.example.assignment3.models.Movie;
import com.example.assignment3.repositories.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    @Override
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

//    @Override
//    public Optional<Movie> getMovieById(int id) {
//        try {
//            return movieRepository.findById(id);
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }

    @Override
    public Movie getById(int id) {
        return getMovieById(id);
    }

    @Override
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public void updateMovieById(int id, Movie movie) {
        movie.setId(id);
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovieById(int id) {
        Movie movie = getMovieById(id);
        movieRepository.delete(movie);
    }

    private Movie getMovieById(int id) {
        return movieRepository.findById(id).orElseThrow(() -> new NotFound("Movie not found with this id: " + id));
    }
}
