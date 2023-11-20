package mongodb.demo.mongodb.controllers;


import mongodb.demo.mongodb.models.Restaurant;
import mongodb.demo.mongodb.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurant")
    Iterable<Restaurant> getAllRestaurant() {
        return restaurantService.getAllRestaurant();
    }

    @PostMapping("/restaurant")
    Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
        return restaurantService.createRestaurant(restaurant);
    }


    @GetMapping("/restaurant/{id}")
    Optional<Restaurant> getRestaurant(@RequestParam String id) throws Throwable {
        return Optional.ofNullable(restaurantService.getRestaurant(String.valueOf(id)));

    }

    @DeleteMapping("/restaurant/{id}")
    void deleteRestaurant(@RequestParam String id) {
        restaurantService.deleteRestaurant(String.valueOf(id));
    }

    @PutMapping("/restaurant")
    Restaurant updateRestaurant(@PathVariable String id, @RequestBody Restaurant restaurant) {
        return restaurantService.updateRestaurant(id, restaurant);
    }

    @DeleteMapping("/restaurant")
    void deleteAll() {
        restaurantService.deleteAllRestaurant();
    }

}
