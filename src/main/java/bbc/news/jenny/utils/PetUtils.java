package bbc.news.jenny.utils;

import bbc.news.jenny.domain.Pet;

import java.util.List;

/**
 * Created by roberj78 on 02/11/2016.
 */
public class PetUtils {

    public static Pet findPetFromListByName(final List<Pet> listOfPets, final String petName) {
        System.out.println("pet name from URL: " + petName);
        for (Pet pet : listOfPets) {

            if (pet.getName().equals(petName)) {
                return pet;

            }
        }
        return null;
    }
}
