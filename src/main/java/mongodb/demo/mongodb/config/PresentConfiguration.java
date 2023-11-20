package mongodb.demo.mongodb.config;


import mongodb.demo.mongodb.models.PresentFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PresentConfiguration {
    @Bean
    public PresentFactory presentsDtoFactory() {
        return new PresentFactory();
    }
}
