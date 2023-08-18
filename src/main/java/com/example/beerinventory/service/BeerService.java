package com.example.beerinventory.service;

import com.example.beerinventory.model.Beer;
import com.example.beerinventory.repository.BeerRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BeerService {

    private final BeerRepository beerRepository;

    public BeerService(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }

    public Beer createBeer(Beer beer) {
        return beerRepository.save(beer);
    }

    public List<Beer> listBeers() {
        return beerRepository.findAll();
    }

    public Beer findBeerByName(String name) {
        return beerRepository.findByName(name);
    }

    public boolean deleteBeer(String name) {
        Beer beer = beerRepository.findByName(name);
        if (beer != null) {
            beerRepository.delete(beer);
            return true;
        }
        return false;
    }
}

