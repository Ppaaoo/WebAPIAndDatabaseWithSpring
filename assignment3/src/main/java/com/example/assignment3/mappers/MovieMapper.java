package com.example.assignment3.mappers;

import com.example.assignment3.models.Character;
import com.example.assignment3.models.Franchise;
import com.example.assignment3.models.Movie;
import com.example.assignment3.models.dto.MovieDto;
import com.example.assignment3.services.CharacterService;
import com.example.assignment3.services.FranchiseService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class MovieMapper {
    @Autowired
    protected CharacterService characterService;
    @Autowired
    protected FranchiseService franchiseService;

    @Mapping(target = "characters", source="characters", qualifiedByName = "charactersToId")
    @Mapping(target = "franchise", source = "franchise.id")
    public abstract MovieDto movieToMovieDto(Movie movie);

    public abstract Collection<MovieDto> movieToMovieDto(Collection<Movie> movies);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "title", source = "title")
    @Mapping(target = "genre", source = "genre")
    @Mapping(target = "releaseYear", source = "releaseYear")
    @Mapping(target = "director", source = "director")
    @Mapping(target = "posterURL", source = "posterURL")
    @Mapping(target = "trailerURL", source = "trailerURL")
    @Mapping(target = "characters", source = "characters", qualifiedByName = "idsToCharacters")
    @Mapping(target = "franchise", source = "franchise", qualifiedByName = "idToFranchise")
    public abstract Movie movieDtoToMovie(MovieDto dto);

    //Custom mappings
    @Named("charactersToId")
    Set<Integer> mapCharactersToIds(Set<Character> source) {
        if (source == null) {
            return null;
        }
        return source.stream()
                .map(movie -> movie.getId()).collect(Collectors.toSet());
    }

    @Named("idsToCharacters")
    Set<Character> mapIdsToMovies(Set<Integer> source) {
        if (source == null) {
            return null;
        }
        return source.stream()
                .map(movieID -> characterService.findById(movieID))
                .collect(Collectors.toSet());
    }

    @Named("idToFranchise")
    Franchise mapFranchiseIdsToMovies(int source) {
        if (source == 0) {
            return null;
        }
        return franchiseService.findById(source);
    }
}
