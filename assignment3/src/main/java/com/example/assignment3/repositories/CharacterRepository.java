package com.example.assignment3.repositories;

import com.example.assignment3.models.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Integer> {
    @Query(value = "SELECT * FROM Character c WHERE c.name LIKE %?%", nativeQuery = true)
    Set<Character> findAllByName(String name);

    @Query(value = "SELECT * FROM Character c WHERE c.id LIKE %?%", nativeQuery = true)
    Set<Character> findAllById(int id);
}
