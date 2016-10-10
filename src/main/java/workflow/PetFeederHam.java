package workflow;

import bbc.news.jenny.domain.Pet;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class PetFeederHam implements PetFeeder {
    public String feed(Pet abstractPet, int amountOfFood) {


        int newHunger = abstractPet.getHunger()+amountOfFood * 1;

        return String.format("Feeding %s the %s %d slices of ham.\n", abstractPet.getName(), abstractPet.getClass().getSimpleName(), amountOfFood);
//
//        if(newHunger >= 0 && newHunger <= 100) {
//
//            abstractPet.setHunger(newHunger);
//        }
//        else if(newHunger >= 100){
//            System.out.printf("%s is too full to eat that!\n", abstractPet.getName());
//        }


    }


}
