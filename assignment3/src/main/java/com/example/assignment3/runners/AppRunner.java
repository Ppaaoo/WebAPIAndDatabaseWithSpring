package com.example.assignment3.runners;

import com.example.assignment3.models.Character;
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
        Character newCharacter = new Character();
        newCharacter.setName("Gandalf");
        addCharacter(newCharacter);

        Movie newMovie = new Movie();
        newMovie.setTitle("The Fellowship of the Ring");
        addMovie(newMovie);

        Franchise newFranchise = new Franchise();
        newFranchise.setName("The Lord of the Rings");
        addFranchise(newFranchise);

        linkMovieToFranchise(4, 2);
    }

    //---CHARACTER---
    public void addCharacter(Character character) {
        characterRepository.save(character);
        System.out.println("Character ID: " + character.getId());
    }

    public void linkCharacterAndMovie(int characterID, int movieID) {
        Character character = characterRepository.findById(characterID).get();
        Movie movie = movieRepository.findById(movieID).get();
        //Find a way to get the JoinTable characters_movies
    }

    //---MOVIE---
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
        System.out.println("Movie ID: " + movie.getId());
    }

    public void linkMovieToFranchise(int movieID, int franchiseID) {
        Movie movie = movieRepository.findById(movieID).get();
        Franchise franchise = franchiseRepository.findById(franchiseID).get();
        movie.setFranchise(franchise);
        movieRepository.save(movie);
        System.out.println("New Franchise ID: " + movie.getFranchise().getId() + " for movie: " + movie.getTitle());
    }

    //---FRANCHISE---
    public void addFranchise(Franchise franchise) {
        franchiseRepository.save(franchise);
        System.out.println("Franchise ID: " + franchise.getId());
    }

}