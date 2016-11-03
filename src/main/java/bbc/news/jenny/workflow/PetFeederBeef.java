package bbc.news.jenny.workflow;

import bbc.news.jenny.domain.Pet;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class PetFeederBeef implements PetFeeder {
    public Integer feed(Pet abstractPet, Integer amountOfFood) {


        Integer newHealth = abstractPet.getHealth() + amountOfFood * 2;


        if (newHealth >= 0 && newHealth <= 100) {
            abstractPet.setHealth(newHealth);
            System.out.println(String.format("Feeding %s the %s %d chunks of beef.\n", abstractPet.getName(), abstractPet.getClass().getSimpleName(), amountOfFood));

        } else if (newHealth <= 100) {
            System.out.println(String.format("%s is too full to eat that!\n", abstractPet.getName()));
        }

        return abstractPet.getHealth();

    }



}
