package com.example.beerinventory;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Arrays;
import java.util.List;
import com.example.beerinventory.model.Beer;
import com.example.beerinventory.repository.BeerRepository;
import com.example.beerinventory.service.BeerService;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class BeerServiceTest {

    @Mock
    private BeerRepository beerRepository;

    @Test
    public void testCreateBeer() {
        BeerService beerService = new BeerService(beerRepository);
        Beer beer = new Beer("IPA", "India Pale Ale", 10);

        when(beerRepository.save(beer)).thenReturn(beer);

        Beer savedBeer = beerService.createBeer(beer);
        assertNotNull(savedBeer);
    }

    @Test
    public void testListBeers() {
        BeerService beerService = new BeerService(beerRepository);

        when(beerRepository.findAll()).thenReturn(Arrays.asList(
                new Beer("IPA", "India Pale Ale", 10),
                new Beer("Stout", "Stout Beer", 8)
        ));

        List<Beer> beers = beerService.listBeers();
        assertEquals(2, beers.size());
    }

    @Test
    public void testFindBeerByName() {
        BeerService beerService = new BeerService(beerRepository);

        when(beerRepository.findByName("IPA")).thenReturn(
                new Beer("IPA", "India Pale Ale", 10)
        );

        Beer foundBeer = beerService.findBeerByName("IPA");
        assertNotNull(foundBeer);
        assertEquals("IPA", foundBeer.getName());
    }

    @Test
    public void testDeleteBeer() {
        BeerService beerService = new BeerService(beerRepository);

        Beer beerToDelete = new Beer("IPA", "India Pale Ale", 10);
        when(beerRepository.findByName("IPA")).thenReturn(beerToDelete);

        boolean isDeleted = beerService.deleteBeer("IPA");
        assertTrue(isDeleted);
    }
}
