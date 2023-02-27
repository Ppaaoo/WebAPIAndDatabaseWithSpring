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
    private String posterURL;
    private String trailerURL;

    @OneToOne
    @JoinColumn(name = "franchise_id")
    private Franchise franchise;

    @OneToMany
    private Set<Character> character;

}
