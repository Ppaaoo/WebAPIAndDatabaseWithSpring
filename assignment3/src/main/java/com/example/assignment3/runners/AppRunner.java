package com.example.assignment3.runners;

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

    public AppRunner(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
    @Override
    @Transactional
    public void run(ApplicationArguments args) throws Exception {
        //movieService.deleteById(1);
        System.out.println("Hello from runner");
        System.out.println(movieRepository.findById(1).get().getCharacters());
    }
}