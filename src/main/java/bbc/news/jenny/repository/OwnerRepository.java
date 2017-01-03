package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@org.springframework.stereotype.Repository
public class OwnerRepository implements Repository<Owner> {

    @Autowired
    private OwnerExtractor ownerExtractor;
    @Autowired
    private OwnerSaver ownerSaver;
    @Autowired
    private OwnerDeleter ownerDeleter;

    public Map<Integer, Owner> load() {
        //Load in owners from database as a list
        return ownerExtractor.extract();

    }

    public int save(Owner owner) {
        System.out.println("Saving to database");
        return ownerSaver.save(owner);

    }

    public void delete(Owner owner) {
        System.out.println("Deleting from database");
        ownerDeleter.delete(owner);

    }


}
