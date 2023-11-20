package mongodb.demo.mongodb.services;


import mongodb.demo.mongodb.models.Clothes;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ClothesService {
    Clothes createClothes(Clothes clothes);
    Clothes getClothes(String id);
    void deleteClothes(String id);
    void deleteAllClothes();
    void saveAllClothes(List<Clothes> clothes);
    Page<Clothes> getClothes(Pageable pageable);
    List<Clothes> getAllClothes();
    Page<Clothes> findClothesMatchingAll(Clothes probe, Pageable pageable);
    Clothes updateClothes(String id, Clothes updatedClothes);
}