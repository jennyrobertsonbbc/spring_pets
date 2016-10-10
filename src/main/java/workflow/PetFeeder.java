package workflow;


import bbc.news.jenny.domain.Pet;

/**
 * Created by roberj78 on 29/09/2016.
 */
public interface PetFeeder {

    public String feed(Pet abstractPet, int amountOfFood);

}
