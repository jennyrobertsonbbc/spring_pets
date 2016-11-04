package bbc.news.jenny.workflow;


import bbc.news.jenny.domain.Pet;


public interface PetFeeder {

    public Integer feed(Pet abstractPet, Integer amountOfFood);

}
