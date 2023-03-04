package com.example.assignment3.controllers;

import com.example.assignment3.mappers.CharacterMapper;
import com.example.assignment3.models.Character;
import com.example.assignment3.models.dto.CharacterDto;
import com.example.assignment3.services.CharacterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/character")
public class CharacterController {
    private final CharacterService characterService;
    private final CharacterMapper characterMapper;

    public CharacterController(CharacterService characterService, CharacterMapper characterMapper) {
        this.characterService = characterService;
        this.characterMapper = characterMapper;
    }

    @GetMapping  // GET: localhost:8080/api/v1/character
    public ResponseEntity getAll() {
        Collection<CharacterDto> characters = characterMapper.characterToDto(
                characterService.findAll()
        );
        return ResponseEntity.ok(characters);
    }


    @GetMapping("/id/{id}") //GET: localhost:8080/api/v1/character/id/1
    public ResponseEntity getById(@PathVariable int id) {
        CharacterDto characterDto = characterMapper.characterToCharacterDto(
                characterService.findById(id)
        );
        return ResponseEntity.ok(characterDto);
    }

    @PostMapping // POST: localhost:8080/api/v1/character
    public ResponseEntity add(@RequestBody Character character) {
        Character charac = characterService.add(character);
        URI location = URI.create("character/" + charac.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}") // PUT: localhost:8080/api/v1/character/1
    public ResponseEntity update(@RequestBody CharacterDto characterDto, @PathVariable int id) {
        if (id != characterDto.getId()) {
            return ResponseEntity.badRequest().build();
        }
        characterService.update(characterMapper.characterDtoToCharacter(characterDto));
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/character/1
    public ResponseEntity delete(@PathVariable int id) {
        characterService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
