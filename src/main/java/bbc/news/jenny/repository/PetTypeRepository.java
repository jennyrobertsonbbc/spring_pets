package bbc.news.jenny.repository;

import bbc.news.jenny.domain.PetType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@org.springframework.stereotype.Repository
public class PetTypeRepository implements Repository<PetType> {

    @Autowired
    private PetTypeExtractor PetTypeExtractor;
    @Autowired
    private PetTypeSaver PetTypeSaver;
    @Autowired
    private PetTypeDeleter PetTypeDeleter;

    public List<PetType> load() {
        //Load in pets from database as a list
        List<PetType> listOfPetTypes;
        listOfPetTypes = PetTypeExtractor.extract();
        return listOfPetTypes;

    }

    public void save(List<PetType> listOfPetTypes) {
        System.out.println("Saving to database");
        PetTypeSaver.save(listOfPetTypes);

    }

    public void delete(PetType petType) {
        System.out.println("Deleting from database");
        PetTypeDeleter.delete(petType);

    }

    public Integer select(String queryString){
        Integer petId = 56;

        return petId;
    }


}
