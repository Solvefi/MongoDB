package mongodb.demo.mongodb.services.impl;


import mongodb.demo.mongodb.models.Present;
import mongodb.demo.mongodb.repos.PresentRepository;
import mongodb.demo.mongodb.services.PresentService;
import mongodb.demo.mongodb.utils.ClientErrorException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PresentServiceImpl implements PresentService {
    private final PresentRepository presentRepo;

    public PresentServiceImpl(PresentRepository presentRepo) {
        this.presentRepo = presentRepo;
    }

    @Override
    public Present createPresent(Present present) {
        presentRepo.save(present);
        return present;
    }

    @Override
    public List<Present> getAllPresent() {
        return presentRepo.findAll();
    }
    @Override
    public Present getPresent(String id) {
        return presentRepo.findById(id)
                .orElseThrow(()->new ClientErrorException.NotFoundException("Подарок с id=[%s] не найден", id));
    }
    @Override
    public void deletePresent(String id) {
        presentRepo.deleteById(id);
    }

    @Override
    public void deleteAllPresent() {
        presentRepo.deleteAll();
    }

    @Override
    public void saveAllPresent(List<Present> present) {
        presentRepo.saveAll(present);
    }

    @Override
    public Present updatePresent(String id, Present updatedPresent) {
        Present existingPresent = presentRepo.findById(id)
                .orElseThrow(() -> new ClientErrorException("Подарок с id=[%s] не найден " + id) {
                });
        existingPresent.setType(updatedPresent.getType());
        existingPresent.setPrice(updatedPresent.getPrice());
        existingPresent.setColor(updatedPresent.getColor());
        existingPresent.setGender(updatedPresent.getGender());

        Present savedPresent = presentRepo.save(existingPresent);

        return savedPresent;
    }

}