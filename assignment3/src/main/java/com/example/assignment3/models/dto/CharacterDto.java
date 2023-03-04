package com.example.assignment3.models.dto;

import lombok.Data;

import java.util.Set;

@Data
public class CharacterDto {
    private int id;
    private String name;
    private String alias;
    private String gender;
    private String pictureUrl;
    private Set<Integer> movies;
}
