package com.example.assignment3.services;

import com.example.assignment3.models.Franchise;

import java.util.Collection;

public interface FranchiseService extends CrudService<Franchise, Integer>{
    Collection<Franchise> findAllByName(String name);
}
