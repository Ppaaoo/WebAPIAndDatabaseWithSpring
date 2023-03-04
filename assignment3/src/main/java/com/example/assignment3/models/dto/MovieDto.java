package com.example.assignment3.models.dto;

import lombok.Data;
import java.util.Set;

@Data
public class MovieDto {
    private int id;
    private String title;
    private String genre;
    private int releaseYear;
    private String director;
    private String posterURL;
    private String trailerURL;
    private Set<Integer> characters;
    private int franchise;
}
