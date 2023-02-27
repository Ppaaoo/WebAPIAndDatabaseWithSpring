package com.example.assignment3.models;

import jakarta.persistence.*;

@Entity
public class Character {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "character_id")
    private int id;
    @Column(name = "character_name", length = 50, nullable = false)
    private String name;
    private String alias;
    private String gender;
    private String pictureURL;
}
