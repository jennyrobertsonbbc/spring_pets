package bbc.news.jenny.workflow;


import bbc.news.jenny.domain.Pet;

/**
 * Created by roberj78 on 29/09/2016.
 */
public interface PetFeeder {

    public Integer feed(Pet abstractPet, Integer amountOfFood);

}
