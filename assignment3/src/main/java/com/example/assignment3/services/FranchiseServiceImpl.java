package com.example.assignment3.services;

import com.example.assignment3.models.Franchise;
import com.example.assignment3.repositories.FranchiseRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class FranchiseServiceImpl implements FranchiseService {
    private final FranchiseRepository franchiseRepository;

    public FranchiseServiceImpl(FranchiseRepository franchiseRepository) {
        this.franchiseRepository = franchiseRepository;
    }
    @Override
    public Franchise findById(Integer integer) {
        return franchiseRepository.findById(integer).get();
    }

    @Override
    public Collection<Franchise> findAll() {
        return franchiseRepository.findAll();
    }

    public Collection<Franchise> findAllByName(String name) {
        return franchiseRepository.findAllByName(name);
    }

    @Override
    public Franchise add(Franchise entity) {
        System.out.println(entity);
        return franchiseRepository.save(entity);
    }

    @Override
    public Franchise update(Franchise entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
