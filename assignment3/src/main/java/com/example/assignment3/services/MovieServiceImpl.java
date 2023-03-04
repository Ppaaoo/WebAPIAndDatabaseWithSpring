package com.example.assignment3.services;

import com.example.assignment3.models.Character;
import com.example.assignment3.models.Movie;
import com.example.assignment3.repositories.CharacterRepository;
import com.example.assignment3.repositories.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;

    public MovieServiceImpl(MovieRepository movieRepository, CharacterRepository characterRepository) {
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
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
        movieRepository.deleteInMoviesCharactersById(id);
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Movie found with id "+ id));
        movie.setCharacters(Collections.<Character>emptySet());
        movieRepository.save(movie);
        movieRepository.deleteById(id);
    }

    @Override
    public Collection<Movie> findAllByName(String name) {
        return movieRepository.findAllByName(name);
    }
}
