package mongodb.demo.mongodb.services;

import mongodb.demo.mongodb.models.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurantService {
    Restaurant createRestaurant(Restaurant restaurant);
    Restaurant getRestaurant(String id);
    void deleteRestaurant(String id);
    void deleteAllRestaurant();
    void saveAllRestaurant(List<Restaurant> restaurants);
    Page<Restaurant> getRestaurant(Pageable pageable);
    List<Restaurant> getAllRestaurant();
    Page<Restaurant> findRestaurantMatchingAll(Restaurant probe, Pageable pageable);
    Restaurant updateRestaurant(String id, Restaurant updatedRestaurant);
}
