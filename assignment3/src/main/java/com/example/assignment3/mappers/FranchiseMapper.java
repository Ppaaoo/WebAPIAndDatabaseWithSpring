package com.example.assignment3.mappers;

import com.example.assignment3.models.Franchise;
import com.example.assignment3.models.Movie;
import com.example.assignment3.models.dto.FranchiseDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class FranchiseMapper {

    @Mapping(target = "moviesInFranchise", source = "moviesInFranchise", qualifiedByName = "moviesToIds")
    public abstract FranchiseDto franchiseToFranchiseDto(Franchise franchise);

    public abstract Collection<FranchiseDto> franchiseToFranchiseDto(Collection<Franchise> franchises);

//    @Mapping(target = "movies", source = "movies")
//    public abstract Franchise franchiseDtoToFranchise(FranchiseDto dto);

    //Custom mappings
    @Named("moviesToIds")
    Set<Integer> mapMoviesToIds(Set<Movie> source) {
        if (source == null) {
            return null;
        }

        return source.stream()
                .map(character -> character.getId()).collect(Collectors.toSet());
    }

    @Named("idsToMovies")
    Set<Movie> mapIdsToMovies(Set<Integer> source) {
        return source.stream()
                .map(franId -> movieService.findById(franId))
                .collect(Collectors.toSet());
    }
}
