package com.example.assignment3.runners;

import com.example.assignment3.models.Franchise;
import com.example.assignment3.models.Movie;
import com.example.assignment3.repositories.CharacterRepository;
import com.example.assignment3.repositories.FranchiseRepository;
import com.example.assignment3.repositories.MovieRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Client class for the Services.
 * This class exists to demonstrate the use of services.
 * It implements ApplicationRunner to be able to use dependency injection.
 */
@Component
public class AppRunner implements ApplicationRunner {
    private final MovieRepository movieRepository;
    private final CharacterRepository characterRepository;
    private final FranchiseRepository franchiseRepository;

    public AppRunner(MovieRepository movieRepository, CharacterRepository characterRepository, FranchiseRepository franchiseRepository) {
        this.movieRepository = movieRepository;
        this.characterRepository = characterRepository;
        this.franchiseRepository = franchiseRepository;
    }
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        //movieService.deleteById(1);
        System.out.println("Hello from runner");
        System.out.println(movieRepository.findById(1).get().getCharacters());
    }

    public void addCharacter(Character character) {

    }
    public void addMovie(Movie movie) {

    }
    public void addFranchise(Franchise franchise) {

    }
}