package com.example.beerinventory.repository;

import com.example.beerinventory.model.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeerRepository extends JpaRepository<Beer, Long> {
    Beer findByName(String name);
}

