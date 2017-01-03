package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@org.springframework.stereotype.Repository
public class PetRepository implements Repository<Pet> {

    @Autowired
    private PetExtractor petExtractor;
    @Autowired
    private PetSaver petSaver;
    @Autowired
    private PetDeleter petDeleter;

    public Map<Integer, Pet> load() {
        //Load in pets from database as a list
        return petExtractor.extract();

    }

    public int save(Pet pet) {
        System.out.println("Saving to database");
        return petSaver.save(pet);

    }

    public void delete(Pet pet) {
        System.out.println("Deleting from database");
        petDeleter.delete(pet);

    }

    public Integer select(String queryString) {
        Integer petId = 56;

        return petId;
    }


}
