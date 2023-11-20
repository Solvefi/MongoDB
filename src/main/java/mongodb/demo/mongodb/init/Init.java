package mongodb.demo.mongodb.init;

import mongodb.demo.mongodb.models.*;
import mongodb.demo.mongodb.services.ClothesService;
import mongodb.demo.mongodb.services.PresentService;
import mongodb.demo.mongodb.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Init implements CommandLineRunner {
    private final RestaurantService restaurantService;
    private final ClothesService clothesService;
    private final PresentService presentService;
    private final RestaurantFactory restaurantFactory;
    private final ClothesFactory clothesFactory;
    private final PresentFactory presentFactory;

    @Autowired
    public Init(RestaurantService restaurantService, ClothesService clothesService, PresentService presentService, RestaurantFactory restaurantFactory, ClothesFactory clothesFactory, PresentFactory presentFactory) {
        this.restaurantService = restaurantService;
        this.clothesService = clothesService;
        this.presentService = presentService;
        this.restaurantFactory = restaurantFactory;
        this.clothesFactory = clothesFactory;
        this.presentFactory = presentFactory;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Clothes> clothes = clothesFactory.listBuilder().clothes(100,100);
        clothesService.saveAllClothes(clothes);

        List<Restaurant> restaurants = restaurantFactory.listBuilder().restaurant(100,100);
        restaurantService.saveAllRestaurant(restaurants);

        List<Present> presents = presentFactory.listBuilder().present(100,100);
        presentService.saveAllPresent(presents);

//        Restaurant restaurant = new Restaurant("Don Omar", "Asian", "Russia", 1000, clothes);
//        System.out.println(restaurantService.createRestaurant(restaurant));



    }
}