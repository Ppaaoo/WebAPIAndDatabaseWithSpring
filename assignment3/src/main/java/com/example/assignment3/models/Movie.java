package com.example.assignment3.models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private int id;
    @Column(name = "movie_title", length = 50, nullable = false)
    private String title;
    private String genre;
    private int releaseYear;
    private String director;
    @Column(name = "poster_url")
    private String posterURL;
    @Column(name = "trailer_url")
    private String trailerURL;

    @ManyToMany
    @JoinTable(
            name = "movie_character",
            joinColumns = {@JoinColumn(name = "movie_id")},
            inverseJoinColumns = {@JoinColumn(name = "character_id")}
    )
    private Set<Character> charactersInMovie;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;


}
