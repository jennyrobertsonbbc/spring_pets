package repository;

import bbc.news.jenny.domain.Pet;

import java.util.List;


public class PetRepository implements Repository<Pet>{

    private PetExtractor petExtractor = new PetExtractor();
    private PetSaver petSaver = new PetSaver();

    public List<Pet> load() {
        //Load in pets from database as a list
        List<Pet> listOfPets = petExtractor.extract();
        return listOfPets;

    }

    public void save(List<Pet> listOfPets) {

        petSaver.save(listOfPets);
    }


}
