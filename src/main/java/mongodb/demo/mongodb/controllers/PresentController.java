package mongodb.demo.mongodb.controllers;


import mongodb.demo.mongodb.models.Present;
import mongodb.demo.mongodb.services.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class PresentController {
    @Autowired
    private PresentService presentService;

    @GetMapping("/present")
    Iterable<Present> getAllPresent() {
        return presentService.getAllPresent();
    }

    @PostMapping("/present")
    Present createPresent(@RequestBody Present present) {
        return presentService.createPresent(present);
    }


    @GetMapping("/present/{id}")
    Optional<Present> getPresent(@RequestParam String id) throws Throwable {
        return Optional.ofNullable(presentService.getPresent(String.valueOf(id)));

    }

    @DeleteMapping("/present/delete/{id}")
    void deletePresent(@RequestParam String id) {
        presentService.deletePresent(String.valueOf(id));
    }

    @PutMapping("/present")
    Present updatePresent(@PathVariable String id, @RequestBody Present present) {
        return presentService.updatePresent(id, present);
    }

    @DeleteMapping("/present")
    void deleteAll() {
        presentService.deleteAllPresent();
    }
}
