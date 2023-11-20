package mongodb.demo.mongodb.controllers;


import mongodb.demo.mongodb.models.Clothes;
import mongodb.demo.mongodb.services.ClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;

@RestController
public class ClothesController {
    @Autowired
    private ClothesService clothesService;

    @GetMapping("/clothes")
    Iterable<Clothes> getAllClothes() {
        return clothesService.getAllClothes();
    }

    @PostMapping("/clothes")
    Clothes createClothes(@RequestBody Clothes clothes) {
        return clothesService.createClothes(clothes);
    }


    @GetMapping("/clothes/{id}")
    Optional<Clothes> getClothes(@RequestParam String id) throws Throwable {
        return Optional.ofNullable(clothesService.getClothes(String.valueOf(id)));

    }

    @DeleteMapping("/clothes/{id}")
    void deleteClothes(@RequestParam String id) {
        clothesService.deleteClothes(String.valueOf(id));
    }

    @PutMapping("/clothes")
    Clothes updateClothes(@PathVariable String id, @RequestBody Clothes clothes) {
        return clothesService.updateClothes(id, clothes);
    }

    @DeleteMapping("/clothes")
    void deleteAll() {
        clothesService.deleteAllClothes();
    }

}
