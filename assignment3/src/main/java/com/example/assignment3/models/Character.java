package com.example.assignment3.models;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "character_name", length = 50, nullable = false)
    private String name;
    private String alias;
    private String gender;
    @Column(name = "picture_url")
    private String pictureURL;

    @ManyToMany(mappedBy = "characters")
    private Set<Movie> movie = new HashSet<>();
}