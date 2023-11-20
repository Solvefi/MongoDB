package mongodb.demo.mongodb.config;


import mongodb.demo.mongodb.models.RestaurantFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RestaurantConfiguration {
    @Bean
    public RestaurantFactory restaurantsDtoFactory() {
        return new RestaurantFactory();
    }
}