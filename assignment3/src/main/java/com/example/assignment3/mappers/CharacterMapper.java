package com.example.assignment3.mappers;

import com.example.assignment3.models.Character;
import com.example.assignment3.models.Movie;
import com.example.assignment3.models.dto.CharacterDto;
import com.example.assignment3.services.MovieService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public abstract class CharacterMapper {
    @Autowired
    protected MovieService movieService;

    @Mapping(target = "movies", source = "movies", qualifiedByName = "moviesToIds")
    public abstract CharacterDto characterToCharacterDto(Character character);

    public abstract Collection<CharacterDto> characterToDto(Collection<Character> characters);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "alias", source = "alias")
    @Mapping(target = "gender", source = "gender")
    @Mapping(target = "pictureURL", source = "pictureUrl")
    @Mapping(target = "movies", source = "movies", qualifiedByName = "idsToMovies")
    public abstract Character characterDtoToCharacter(CharacterDto dto);


    //Custom mappings
    @Named("moviesToIds")
    Set<Integer> mapMoviesToIds(Set<Movie> source) {
        if (source == null) {
            return null;
        }

        return source.stream()
                .map(movie -> movie.getId())
                .collect(Collectors.toSet());
    }
    @Named(("idsToMovies"))
    Set<Movie> mapCharIdsToMovies(Set<Integer> source) {
        return source.stream()
                .map(charId -> movieService.findById(charId))
                .collect(Collectors.toSet());
    }
}
