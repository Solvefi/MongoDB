package mongodb.demo.mongodb.config;


import mongodb.demo.mongodb.models.ClothesFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClothesConfiguration {
    @Bean
    public ClothesFactory clothesDtoFactory() {
        return new ClothesFactory();
    }
}
