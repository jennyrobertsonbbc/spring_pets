package bbc.news.jenny.workflow;

import bbc.news.jenny.domain.Pet;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class PetFeederHam implements PetFeeder {
    public String feed(Pet abstractPet, Integer amountOfFood) {


        Integer newhealth = abstractPet.getHealth() + amountOfFood * 1;

        return String.format("Feeding %s the %s %d slices of ham.\n", abstractPet.getName(), abstractPet.getClass().getSimpleName(), amountOfFood);
//
//        if(newhealth >= 0 && newhealth <= 100) {
//
//            abstractPet.sethealth(newhealth);
//        }
//        else if(newhealth >= 100){
//            System.out.printf("%s is too full to eat that!\n", abstractPet.getName());
//        }


    }


}
