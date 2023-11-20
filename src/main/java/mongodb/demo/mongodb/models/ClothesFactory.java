package mongodb.demo.mongodb.models;

import com.github.javafaker.Faker;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ClothesFactory {
    private static AtomicInteger nextId = new AtomicInteger(1);
    private final Faker faker = new Faker();
    public String color() { return faker.options().option("Black", "White", "Pink", "Red", " Green", "Blue", "Gray", "Orange"); }
    public String size() { return faker.options().option("XS", "S", "M", "L", "XL", "XXL", "XXXL"); }
    public String gender() { return faker.options().option("Female", "Male"); }
    public String type() { return faker.options().option("Dress", "Pants", "Shirt", "Jacket", "Skirt"); }

    public Clothes make(UnaryOperator<Clothes>...clothes) {
        final Clothes result = new Clothes(size(), color(), gender(), type());
        Stream.of(clothes).forEach(v->v.apply(result));
        return result;
    }

    public static UnaryOperator<Clothes> oneUpId = s->{
        s.setId(Integer.valueOf(nextId.getAndAdd(1)).toString());
        return s;
    };

    public ClothesListDTOFactory listBuilder() { return new ClothesListDTOFactory(); }

    public class ClothesListDTOFactory {
        public List<Clothes> clothes(int min, int max, UnaryOperator<Clothes>...clothes) {
            return IntStream.range(0, faker.number().numberBetween(min, max))
                    .mapToObj(i-> ClothesFactory.this.make(clothes))
                    .collect(Collectors.toList());
        }
    }
}
