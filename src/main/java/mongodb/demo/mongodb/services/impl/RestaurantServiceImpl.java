package mongodb.demo.mongodb.services.impl;


import mongodb.demo.mongodb.models.Restaurant;
import mongodb.demo.mongodb.repos.ClothesRepository;
import mongodb.demo.mongodb.repos.RestaurantRepository;
import mongodb.demo.mongodb.services.ClothesService;
import mongodb.demo.mongodb.services.RestaurantService;
import mongodb.demo.mongodb.utils.ClientErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepo;

    private final ClothesService clothesService;
    private final ClothesRepository clothesRepository;

    @Autowired
    public RestaurantServiceImpl(RestaurantRepository restaurantRepo, ClothesService clothesService, ClothesRepository clothesRepository) {
        this.restaurantRepo = restaurantRepo;
        this.clothesService = clothesService;
        this.clothesRepository = clothesRepository;
    }

    @Override
    public Restaurant createRestaurant(Restaurant restaurant) {
        restaurantRepo.save(restaurant);
        return restaurant;
    }
    @Override
    public Page<Restaurant> getRestaurant(Pageable pageable) {
        Page<Restaurant> restaurant = restaurantRepo.findAll(pageable);
        return restaurant;
    }
    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepo.findAll();
    }
    @Override
    public Restaurant getRestaurant(String id) {
        return restaurantRepo.findById(id)
                .orElseThrow(()->new ClientErrorException.NotFoundException("Ресторан с id=[%s] не найден", id));
    }
    @Override
    public void deleteRestaurant(String id) {
//        Restaurant restaurant = getRestaurant(id);
//        System.out.println(restaurant.getClothes());
//        for(var r: restaurant.getClothes()){
//            clothesService.deleteClothes(r.getId());
//        }
        restaurantRepo.deleteById(id);
    }

    @Override
    public void deleteAllRestaurant() {
        restaurantRepo.deleteAll();
    }

    @Override
    public void saveAllRestaurant(List<Restaurant> restaurant) {
        restaurantRepo.saveAll(restaurant);
    }
    @Override
    public Page<Restaurant> findRestaurantMatchingAll(Restaurant probe, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();
        Page<Restaurant> restaurant = restaurantRepo.findAll(Example.of(probe, matcher), pageable);
        return restaurant;
    }

    @Override
    public Restaurant updateRestaurant(String id, Restaurant updatedRestaurant) {
        Restaurant existingRestaurant = restaurantRepo.findById(id)
                .orElseThrow(() -> new ClientErrorException("Ресторан с id=[%s] не найден" + id) {
                });
        existingRestaurant.setAdress(updatedRestaurant.getAddress());
        existingRestaurant.setCuisine(updatedRestaurant.getCuisine());
        existingRestaurant.setCheck(updatedRestaurant.getCheck());
        existingRestaurant.setName(updatedRestaurant.getName());

        Restaurant savedRestaurant = restaurantRepo.save(existingRestaurant);

        return savedRestaurant;
    }
}


