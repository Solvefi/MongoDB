package mongodb.demo.mongodb.repos;


import mongodb.demo.mongodb.models.Clothes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClothesRepository extends MongoRepository<Clothes, String> {
    Optional<Clothes> getByColor(String color);
    List<Clothes> findByColor(String color);
    List<Clothes> findByColorNot(String color);
    List<Clothes> findByColorContaining(String string);
    List<Clothes> findByColorNotContaining(String color);
    List<Clothes> findByColorMatches(String string);
    List<Clothes> findByColorStartingWith(String string, Sort sort);
    Slice<Clothes> findByColorStartingWith(String string, Pageable pageable);
    Page<Clothes> findPageByColorStartingWith(String string, Pageable pageable);
}