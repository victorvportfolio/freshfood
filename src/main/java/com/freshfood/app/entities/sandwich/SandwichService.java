package com.freshfood.app.entities.sandwich;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SandwichService {
    private final SandwichRepository sandwichRepository;

    @Autowired
    public SandwichService(SandwichRepository sandwichRepository) {
        this.sandwichRepository = sandwichRepository;
    }

    public Sandwich getSandwich(Integer id){
        return sandwichRepository
                .findById(id)
                .orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Sandwich not found"));
    }

    public List<Sandwich> getAllSandwiches(){
        return sandwichRepository.findAll();
    }
}
