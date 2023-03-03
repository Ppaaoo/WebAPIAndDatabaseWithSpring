package com.example.assignment3.models.dto;

import lombok.Data;

import java.util.Set;

@Data
public class FranchiseDto {
    private int id;
    private String name;
    private String description;
    private Set<Integer> moviesInFranchise;
}
