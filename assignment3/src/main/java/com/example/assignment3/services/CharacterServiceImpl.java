package com.example.assignment3.services;

import com.example.assignment3.models.Character;
import com.example.assignment3.repositories.CharacterRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class CharacterServiceImpl implements CharacterService {
    private final CharacterRepository characterRepository;

    public CharacterServiceImpl(CharacterRepository characterRepository) {
        this.characterRepository = characterRepository;
    }
    @Override
    public Character findById(Integer integer) {
        return null;
    }

    @Override
    public Collection<Character> findAll() {
        return null;
    }

    @Override
    public Character add(Character entity) {
        return null;
    }

    @Override
    public Character update(Character entity) {
        return null;
    }

    @Override
    public void deleteById(Integer integer) {

    }
}
