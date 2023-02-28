package com.example.assignment3.models;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Set;

@Entity
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "movie_title", length = 50, nullable = false)
    private String title;
    private String genre;
    @Column(name = "release_year")
    private int releaseYear;
    private String director;
    @Column(name = "poster_url")
    private String posterURL;
    @Column(name = "trailer_url")
    private String trailerURL;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "movies_characters",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "character_id"))
    private Collection<Character> characters;

    @ManyToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;


}
