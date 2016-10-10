package workflow;

import bbc.news.jenny.domain.Pet;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class PetFeederBeef implements PetFeeder {
    public String feed(Pet abstractPet, int amountOfFood) {


        int newHunger = abstractPet.getHunger() + amountOfFood * 2;


        if (newHunger >= 0 && newHunger <= 100) {


            abstractPet.setHunger(newHunger);

            return String.format("Feeding %s the %s %d chunks of beef.\n", abstractPet.getName(), abstractPet.getClass().getSimpleName(), amountOfFood);
        } else if (newHunger <= 100) {
            return String.format("%s is too full to eat that!\n", abstractPet.getName());
        }

        return null;

    }



}
