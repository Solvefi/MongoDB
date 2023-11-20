package mongodb.demo.mongodb.services;


import mongodb.demo.mongodb.models.Present;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PresentService {
    Present createPresent(Present present);
    Present getPresent(String id);
    void deletePresent(String id);
    void deleteAllPresent();
    void saveAllPresent(List<Present> presents);
    List<Present> getAllPresent();
    Present updatePresent(String id, Present updatedPresent);
}