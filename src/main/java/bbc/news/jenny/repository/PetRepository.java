package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository
public class PetRepository implements Repository<Pet> {

    @Autowired
    private PetExtractor petExtractor;
    @Autowired
    private PetSaver petSaver;
    @Autowired
    private PetDeleter petDeleter;

    public List<Pet> load() {
        //Load in pets from database as a list
        List<Pet> listOfPets;
        listOfPets = petExtractor.extract();
        System.out.println("Loading in from database");
        return listOfPets;

    }

    public void save(List<Pet> listOfPets) {
        System.out.println("Saving to database");
        petSaver.save(listOfPets);

    }

    public void delete(Pet pet) {
        System.out.println("Deleting from database");
        petDeleter.delete(pet);

    }


}
