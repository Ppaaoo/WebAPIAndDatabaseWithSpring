package com.example.assignment3.services;

import com.example.assignment3.models.Movie;

import java.util.Collection;

public interface MovieService extends CrudService<Movie, Integer>{
    Collection<Movie> findAllByName(String name);
}
