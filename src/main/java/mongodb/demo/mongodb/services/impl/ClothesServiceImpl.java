package mongodb.demo.mongodb.services.impl;

import mongodb.demo.mongodb.models.Clothes;
import mongodb.demo.mongodb.repos.ClothesRepository;
import mongodb.demo.mongodb.services.ClothesService;
import mongodb.demo.mongodb.utils.ClientErrorException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesServiceImpl implements ClothesService {
    private final ClothesRepository clothesRepo;

    public ClothesServiceImpl(ClothesRepository clothesRepo) {
        this.clothesRepo = clothesRepo;
    }

    @Override
    public Clothes createClothes(Clothes clothes) {
        clothesRepo.save(clothes);
        return clothes;
    }
    @Override
    public Page<Clothes> getClothes(Pageable pageable) {
        Page<Clothes> clothes = clothesRepo.findAll(pageable);
        return clothes;
    }
    @Override
    public List<Clothes> getAllClothes() {
        return clothesRepo.findAll();
    }
    @Override
    public Clothes getClothes(String id) {
        return clothesRepo.findById(id)
                .orElseThrow(()->new ClientErrorException.NotFoundException("Одежда с id=[%s] не найдена", id));
    }
    @Override
    public void deleteClothes(String id) {
        clothesRepo.deleteById(id);
    }

    @Override
    public void deleteAllClothes() {
        clothesRepo.deleteAll();
    }

    @Override
    public void saveAllClothes(List<Clothes> clothes) {
        clothesRepo.saveAll(clothes);
    }
    @Override
    public Page<Clothes> findClothesMatchingAll(Clothes probe, Pageable pageable) {
        ExampleMatcher matcher = ExampleMatcher.matchingAll();
        Page<Clothes> clothes = clothesRepo.findAll(Example.of(probe, matcher), pageable);
        return clothes;
    }
    @Override
    public Clothes updateClothes(String id, Clothes updatedClothes) {
        Clothes existingClothes = clothesRepo.findById(id)
                .orElseThrow(() -> new ClientErrorException("Одежда с id=[%s] не найдена" + id) {
                });
        existingClothes.setType(updatedClothes.getType());
        existingClothes.setSize(updatedClothes.getSize());
        existingClothes.setColor(updatedClothes.getColor());
        existingClothes.setGender(updatedClothes.getGender());

        Clothes savedClothes = clothesRepo.save(existingClothes);

        return savedClothes;
    }
}