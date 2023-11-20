package mongodb.demo.mongodb.init;

import mongodb.demo.mongodb.models.Clothes;
import mongodb.demo.mongodb.models.Present;
import mongodb.demo.mongodb.models.Restaurant;
import mongodb.demo.mongodb.services.ClothesService;
import mongodb.demo.mongodb.services.PresentService;
import mongodb.demo.mongodb.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CustomCode implements CommandLineRunner {
    private final RestaurantService restaurantService;
    private final ClothesService clothesService;
    private final PresentService presentService;

    @Autowired
    public CustomCode(RestaurantService restaurantService, ClothesService clothesService, PresentService presentService) {
        this.restaurantService = restaurantService;
        this.clothesService = clothesService;
        this.presentService = presentService;
    }


    @Override
    public void run(String... args) throws Exception {

        List<Restaurant> storedRestaurants = restaurantService.getAllRestaurant();
        for (Restaurant r:storedRestaurants) {
            System.out.println(r);
        }

        List<Clothes> storedClothes = clothesService.getAllClothes();
        for (Clothes c:storedClothes) {
            System.out.println(c);
        }

        List<Present> storedPresents = presentService.getAllPresent();
        for (Present p:storedPresents) {
            System.out.println(p);
        }
    }
}
