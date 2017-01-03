package bbc.news.jenny.repository;

import bbc.news.jenny.domain.PetType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@org.springframework.stereotype.Repository
public class PetTypeRepository implements Repository<PetType> {

    @Autowired
    private PetTypeExtractor PetTypeExtractor;
    @Autowired
    private PetTypeSaver PetTypeSaver;
    @Autowired
    private PetTypeDeleter PetTypeDeleter;

    public Map<Integer, PetType> load() {
        //Load in pets from database as a list
        Map<Integer, PetType> mapOfPetTypes;
        mapOfPetTypes = PetTypeExtractor.extract();
        return mapOfPetTypes;

    }

    public int save(PetType petType) {
        System.out.println("Saving to database");
        PetTypeSaver.save(petType);
        return 0;

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
