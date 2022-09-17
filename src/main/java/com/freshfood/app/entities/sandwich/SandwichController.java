package com.freshfood.app.entities.sandwich;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sandwiches")
public class SandwichController {
    private final SandwichService sandwichService;
    @Autowired
    public SandwichController(SandwichService sandwichService) {
        this.sandwichService = sandwichService;
    }
@GetMapping("/get-all")
    public List<Sandwich> getAllSandwich(){
        return sandwichService.getAllSandwiches();
    }
}
