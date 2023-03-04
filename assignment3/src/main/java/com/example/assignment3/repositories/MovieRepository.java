package com.example.assignment3.repositories;

import com.example.assignment3.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {
    @Query(value = "SELECT * FROM movie m WHERE m.movie_title LIKE %?%", nativeQuery = true)
    Set<Movie> findAllByName(String title);

    @Query(value = "SELECT * FROM movie m WHERE m.id = ?", nativeQuery = true)
    Set<Movie> findAllById(int id);

    @Query(value = "SELECT * FROM movie m WHERE m.franchise_id = ?", nativeQuery = true)
    Set<Movie> findAllByFranchise(int id);

    @Query(value = "SELECT * FROM movies_character mc WHERE mc.movies_id = ?", nativeQuery = true)
    Set<Integer> findMoviesInMoviesCharacters(int id);

    //@Modifying
    //@Query(value = "DELETE FROM movies_characters mc WHERE mc.movie_id = ?", nativeQuery = true)
    void deleteInMoviesCharactersById(Integer id);
}