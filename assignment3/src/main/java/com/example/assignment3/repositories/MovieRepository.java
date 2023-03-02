package com.example.assignment3.repositories;

import com.example.assignment3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT * FROM Movie m WHERE m.title LIKE %?%", nativeQuery = true)
    Set<Movie> findAllByTitle(String title);

    @Query(value = "SELECT * FROM Movie m WHERE m.movie_id = ?", nativeQuery = true)
    Set<Movie> findAllById(int id);

    @Query(value = "SELECT * FROM Movie m WHERE m.franchise_id = ?", nativeQuery = true)
    Set<Movie> findAllByFranchise(int id);
}
