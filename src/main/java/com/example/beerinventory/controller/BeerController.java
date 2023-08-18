package com.example.beerinventory.controller;

import com.example.beerinventory.model.Beer;
import com.example.beerinventory.service.BeerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/beers")
public class BeerController {

    private final BeerService beerService;

    public BeerController(BeerService beerService) {
        this.beerService = beerService;
    }

    @PostMapping
    public Beer createBeer(@RequestBody Beer beer) {
        return beerService.createBeer(beer);
    }

    @GetMapping
    public List<Beer> listBeers() {
        return beerService.listBeers();
    }

    @GetMapping("/{name}")
    public Beer findBeerByName(@PathVariable String name) {
        return beerService.findBeerByName(name);
    }

    @DeleteMapping("/{name}")
    public boolean deleteBeer(@PathVariable String name) {
        return beerService.deleteBeer(name);
    }
}

