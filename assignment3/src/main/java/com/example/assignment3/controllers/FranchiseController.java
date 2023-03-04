package com.example.assignment3.controllers;

import com.example.assignment3.mappers.FranchiseMapper;
import com.example.assignment3.models.Franchise;
import com.example.assignment3.models.dto.FranchiseDto;
import com.example.assignment3.services.FranchiseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@RestController
@RequestMapping(path = "api/v1/franchise")
public class FranchiseController {

    private final FranchiseService franchiseService;
    private final FranchiseMapper franchiseMapper;

    public FranchiseController(FranchiseService franchiseService, FranchiseMapper franchiseMapper) {
        this.franchiseService = franchiseService;
        this.franchiseMapper = franchiseMapper;
    }

    @GetMapping// GET: localhost:8080/api/v1/franchise
    public ResponseEntity getAll() {
        Collection<FranchiseDto> franchises = franchiseMapper.franchiseToFranchiseDto(
                franchiseService.findAll()
        );
        return ResponseEntity.ok(franchises);
    }

    @GetMapping("/id/{id}") // GET: localhost:8080/api/v1/franchise/id/1
    public ResponseEntity getById(@PathVariable int id) {
        FranchiseDto franchise = franchiseMapper.franchiseToFranchiseDto(
            franchiseService.findById(id)
        );
        return ResponseEntity.ok(franchise);
    }

    @GetMapping("search") //GET: localhost:8080/api/v1/franchise?name=Marvel
    public ResponseEntity<Collection<Franchise>> findByName(@RequestParam String name) {
        return ResponseEntity.ok(franchiseService.findAllByName(name));
    }

    @PostMapping // POST: localhost:8080/api/v1/franchise
    public ResponseEntity addFranchise(@RequestBody Franchise franchise) {
        Franchise fran = franchiseService.add(franchise);
        URI location = URI.create("franchise/" + fran.getId());
        return ResponseEntity.created(location).build();
    }

    @PutMapping("{id}") // PUT: localhost:8080/api/v1/franchise/1
    public ResponseEntity update(@RequestBody FranchiseDto franchiseDto, @PathVariable int id) {
        //Validates body
        if(id != franchiseDto.getId())
            return ResponseEntity.badRequest().build();
        franchiseService.update(
                franchiseMapper.franchiseDtoToFranchise(franchiseDto)
        );
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("{id}") // DELETE: localhost:8080/api/v1/franchise/1
    public ResponseEntity delete(@PathVariable int id) {
        franchiseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
