package bbc.news.jenny.utils;

import bbc.news.jenny.domain.Pet;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Pet> findPetFromListByPartialName(final List<Pet> listOfPets, final String queryString) {
        System.out.println("queryString from URL: " + queryString);
        List<Pet> listOfSelectedPets = new ArrayList<Pet>();

        for (Pet pet : listOfPets) {

            if (pet.getName().toLowerCase().contains(queryString.toLowerCase())) {
                listOfSelectedPets.add(pet);

            }
        }
        return listOfSelectedPets;
    }
}
