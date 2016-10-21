package repository;

import bbc.news.jenny.domain.Pet;

import java.util.ArrayList;
import java.util.List;


public class PetRepository implements Repository<Pet>{

    private PetExtractor petExtractor = new PetExtractor();
    private PetSaver petSaver = new PetSaver();
    private PetDeleter petDeleter = new PetDeleter();

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

    public void delete(Pet pet){
        System.out.println("Deleting from database");
        petDeleter.delete(pet);

    }




}
