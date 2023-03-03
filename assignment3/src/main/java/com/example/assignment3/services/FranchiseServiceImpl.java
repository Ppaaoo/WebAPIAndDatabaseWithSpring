package com.example.assignment3.services;

import com.example.assignment3.models.Franchise;
import com.example.assignment3.models.Movie;
import com.example.assignment3.repositories.FranchiseRepository;
import com.example.assignment3.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    private final FranchiseRepository franchiseRepository;
    private final MovieRepository movieRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository, MovieRepository movieRepository) {
        this.franchiseRepository = franchiseRepository;
        this.movieRepository = movieRepository;
    }
    @Override
    public Franchise findById(Integer integer) {
        return franchiseRepository.findById(integer)
                .orElseThrow(); //Might need to implement custom error??
    }

    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    public Collection<Franchise> findAllByName(String name) {
        return franchiseRepository.findAllByName(name);
    }

    @Override
    public Franchise add(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    public Franchise update(Franchise entity) {
        return franchiseRepository.save(entity);
    }

    @Override
    public void deleteById(Integer id) {
        Set<Movie> movies = movieRepository.findAllByFranchise(id);
        for (Movie movie : movies) {
            movie.setFranchise(null);
        }
        movieRepository.saveAll(movies);
        franchiseRepository.deleteById(id);
    }
}
