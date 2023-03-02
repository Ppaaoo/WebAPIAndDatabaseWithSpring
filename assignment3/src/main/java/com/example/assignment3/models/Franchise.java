package com.example.assignment3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "franchise_name", length = 50, nullable = false)
    private String name;
    private String description;
    @OneToMany(mappedBy = "franchise")
    @JsonIgnore
    private Set<Movie> moviesInFranchise;

    @Override
    public String toString() {
        return "Franchise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Movie> getMoviesInFranchise() {
        return moviesInFranchise;
    }

    public void setMoviesInFranchise(Set<Movie> moviesInFranchise) {
        this.moviesInFranchise = moviesInFranchise;
    }
}
