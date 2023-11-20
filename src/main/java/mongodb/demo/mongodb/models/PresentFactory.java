package mongodb.demo.mongodb.models;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class PresentFactory {
    private static AtomicInteger nextId = new AtomicInteger(1);
    private final Faker faker = new Faker();
    public String color() { return faker.options().option("Black", "White", "Pink", "Red", " Green", "Blue", "Gray", "Ruby"); }
    public String gender() { return faker.options().option("Female", "Male"); }
    public String type() { return faker.options().option("Jewelry", "Game", "Flowers", "Candle", "Pajams", "Wine", "Pie"); }
    public int price() { return faker.options().option(25, 50, 75, 100, 125, 200, 250, 500, 1000, 2500); }


    public Present make(UnaryOperator<Present>...present) {
        final Present result = new Present(type(), color(), gender(), price() );
        Stream.of(present).forEach(v->v.apply(result));
        return result;
    }

    public static UnaryOperator<Present> oneUpId = s->{
        s.setId(Integer.valueOf(nextId.getAndAdd(1)).toString());
        return s;
    };

    public PresentListDTOFactory listBuilder() { return new PresentListDTOFactory(); }

    public class PresentListDTOFactory {
        public List<Present> present(int min, int max, UnaryOperator<Present>...present) {
            return IntStream.range(0, faker.number().numberBetween(min, max))
                    .mapToObj(i-> PresentFactory.this.make(present))
                    .collect(Collectors.toList());
        }
    }
}
