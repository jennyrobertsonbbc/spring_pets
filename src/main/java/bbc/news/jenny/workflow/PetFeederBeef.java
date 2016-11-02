package bbc.news.jenny.workflow;

import bbc.news.jenny.domain.Pet;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class PetFeederBeef implements PetFeeder {
    public String feed(Pet abstractPet, Integer amountOfFood) {


        Integer newhealth = abstractPet.getHealth() + amountOfFood * 2;


        if (newhealth >= 0 && newhealth <= 100) {


            abstractPet.sethealth(newhealth);

            return String.format("Feeding %s the %s %d chunks of beef.\n", abstractPet.getName(), abstractPet.getClass().getSimpleName(), amountOfFood);
        } else if (newhealth <= 100) {
            return String.format("%s is too full to eat that!\n", abstractPet.getName());
        }

        return null;

    }



}
