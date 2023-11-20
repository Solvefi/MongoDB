package mongodb.demo.mongodb.models;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RestaurantFactory {
    private static AtomicInteger nextId = new AtomicInteger(1);
    private final Faker faker = new Faker();
    public String name() { return faker.options().option("Fresh", "Don Omar", "Le Carre", "Geraldine", "We Cideria", "Steaks", "BurgCity","Spicy Food", "Subzero"); }
    public String cuisine() { return faker.options().option("Italian", "French", "Asian", "American", "European"); }
    public String address() { return faker.options().option("Russia", "America", "England", "Japan", "France", "Italy", "China", "Latvian"); }
    public int price() { return faker.options().option(25, 50, 75, 100, 200, 500, 1000, 2500); }


    public Restaurant make(UnaryOperator<Restaurant>...restaurant) {
        final Restaurant result = new Restaurant(name(),cuisine(),address(),price());
        Stream.of(restaurant).forEach(v->v.apply(result));
        return result;
    }

    public static UnaryOperator<Restaurant> oneUpId = s->{
        s.setId(Integer.valueOf(nextId.getAndAdd(1)).toString());
        return s;
    };

    public RestaurantListDTOFactory listBuilder() { return new RestaurantListDTOFactory(); }

    public class RestaurantListDTOFactory {
        public List<Restaurant> restaurant(int min, int max, UnaryOperator<Restaurant>...restaurant) {
            return IntStream.range(0, faker.number().numberBetween(min, max))
                    .mapToObj(i-> RestaurantFactory.this.make(restaurant))
                    .collect(Collectors.toList());
        }
    }

}
