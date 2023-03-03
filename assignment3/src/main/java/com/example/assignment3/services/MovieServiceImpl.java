package com.example.assignment3.services;

import com.example.assignment3.models.Movie;
import com.example.assignment3.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    public Movie findById(Integer id) {
        return movieRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public Collection<Movie> findAll() {
        return movieRepository.findAll();
    }

    @Override
    public Movie add(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    public Movie update(Movie entity) {
        return movieRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        movieRepository.deleteById(id);
    }
}
