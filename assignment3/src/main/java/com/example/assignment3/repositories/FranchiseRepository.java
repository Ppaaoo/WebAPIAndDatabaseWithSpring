package com.example.assignment3.repositories;

import com.example.assignment3.models.Franchise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface FranchiseRepository extends JpaRepository<Franchise, Integer> {
    @Query(value = "SELECT * FROM Franchise f WHERE f.name LIKE %?%", nativeQuery = true)
    Set<Franchise> findAllByName(String name);

    @Query(value = "SELECT * FROM Franchise f WHERE f.id LIKE %?%", nativeQuery = true)
    Set<Franchise> findAllById(int id);
}
