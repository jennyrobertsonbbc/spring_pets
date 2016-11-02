package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Owner;

import java.util.List;

/**
 * Created by roberj78 on 07/10/2016.
 */
public class OwnerRepository implements Repository<Owner> {


    private OwnerExtractor ownerExtractor = new OwnerExtractor();
    private OwnerSaver ownerSaver = new OwnerSaver();

    public List<Owner> load() {
        //Load in pets from database as a list
        List<Owner> listOfOwners = ownerExtractor.extract();
        return listOfOwners;

    }

    public void save(List<Owner> listOfOwners) {

        ownerSaver.save(listOfOwners);
    }

    public void delete(Owner owner) {
        System.out.println("Deleting from database");
        //todo add owner deleter

    }

}
