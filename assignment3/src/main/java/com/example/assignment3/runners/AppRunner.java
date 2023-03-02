package com.example.assignment3.runners;

import com.example.assignment3.models.Character;
import com.example.assignment3.models.Franchise;
import com.example.assignment3.models.Movie;
import com.example.assignment3.repositories.CharacterRepository;
import com.example.assignment3.repositories.FranchiseRepository;
import com.example.assignment3.repositories.MovieRepository;
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
    //@Transactional
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
        //System.out.println(movieRepository.findAllByFranchise(2));
        System.out.println(characterRepository.findCharactersByMovieId(1));
    }

    //---CHARACTER---
    public void addCharacter(Character character) {
        characterRepository.save(character);
        System.out.println("Character ID: " + character.getId());
    }
    public void updateCharacterAlias(int id, String alias) {
        Character character = characterRepository.findById(id).get();
        character.setAlias(alias);
        characterRepository.save(character);
        System.out.println("Alias updated to: " + alias + " for character with id: " + id);
    }
    public void updateCharacterGender(int id, String gender) {
        Character character = characterRepository.findById(id).get();
        character.setGender(gender);
        characterRepository.save(character);
        System.out.println("Gender updated to: " + gender + " for character with id: " + id);
    }
    public void updateCharacterPictureURL(int id, String pictureURL) {
        Character character = characterRepository.findById(id).get();
        character.setPictureURL(pictureURL);
        characterRepository.save(character);
        System.out.println("Picture URL updated to: " + pictureURL + " for character with id: " + id);
    }
    public void updateCharacterName(int id, String name) {
        Character character = characterRepository.findById(id).get();
        character.setName(name);
        characterRepository.save(character);
        System.out.println("Name updated to: " + name + " for character with id: " + id);
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

    public void updateMovieDirection(int id, String director) {
        Movie movie = movieRepository.findById(id).get();
        movie.setDirector(director);
        movieRepository.save(movie);
        System.out.println("Director updated to: " + director + " for movie with id: " + id);
    }

    public void updateMovieGenre(int id, String genre) {
        Movie movie = movieRepository.findById(id).get();
        movie.setGenre(genre);
        movieRepository.save(movie);
        System.out.println("Genre updated to: " + genre + " for movie with id: " + id);
    }
    public void updateMoviePosterURL(int id, String posterURL) {
        Movie movie = movieRepository.findById(id).get();
        movie.setPosterURL(posterURL);
        movieRepository.save(movie);
        System.out.println("Poster URL updated to: " + posterURL + " for movie with id: " + id);
    }
    public void updateMovieReleaseYear(int id, int releaseYear) {
        Movie movie = movieRepository.findById(id).get();
        movie.setReleaseYear(releaseYear);
        movieRepository.save(movie);
        System.out.println("Release year updated to: " + releaseYear + " for movie with id: " + id);
    }
    public void updateMovieTitle(int id, String title) {
        Movie movie = movieRepository.findById(id).get();
        movie.setTitle(title);
        movieRepository.save(movie);
        System.out.println("Title updated to: " + title + " for movie with id: " + id);
    }
    public void updateMovieTrailerURL(int id, String trailerURL) {
        Movie movie = movieRepository.findById(id).get();
        movie.setTrailerURL(trailerURL);
        movieRepository.save(movie);
        System.out.println("Trailer URL updated to: " + trailerURL + " for movie with id: " + id);
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
    public void updateFranchiseDescription(int id, String description) {
        Franchise franchise = franchiseRepository.findById(id).get();
        franchise.setDescription(description);
        franchiseRepository.save(franchise);
        System.out.println("Description updated to: " + description + " for franchise with id: " + id);
    }
    public void updateFranchiseName(int id, String name) {
        Franchise franchise = franchiseRepository.findById(id).get();
        franchise.setName(name);
        franchiseRepository.save(franchise);
        System.out.println("Name updated to: " + name + " for franchise with id: " + id);
    }
}