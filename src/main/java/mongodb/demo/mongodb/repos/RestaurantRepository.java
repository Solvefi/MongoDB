package mongodb.demo.mongodb.repos;


import mongodb.demo.mongodb.models.Restaurant;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant, String> {
    Optional<Restaurant> getByCuisine(String cuisine);
    List<Restaurant> findByCuisine(String cuisine);
    List<Restaurant> findByCuisineNot(String Cuisine);
    List<Restaurant> findByNameContaining(String string);
    List<Restaurant> findByNameNotContaining(String name);
    List<Restaurant> findByCuisineMatches(String string);
    List<Restaurant> findByCheckGreaterThanEqual(int check);
    @Query("{ 'check': { $gte: ?0, $lte: ?1 } }")
    List<Restaurant> findByCuisineStartingWith(String string, Sort sort);
    Slice<Restaurant> findByCuisineStartingWith(String string, Pageable pageable);
    Page<Restaurant> findPageByCuisineStartingWith(String string, Pageable pageable);
}