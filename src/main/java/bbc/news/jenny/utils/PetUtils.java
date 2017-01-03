package bbc.news.jenny.utils;

import bbc.news.jenny.domain.Pet;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PetUtils {

    public static Pet findPetByName(final Map<Integer, Pet> mapOfPets, final String petName) {
        System.out.println("pet name from URL: " + petName);

        for (Pet pet : mapOfPets.values()) {
            if (pet.getName().equals(petName)) {
                return pet;

            }
        }
        return null;
    }

    public static List<Pet> findPetByPartOfName(final Map<Integer, Pet> mapOfPets, final String queryString) {
        System.out.println("queryString from URL: " + queryString);
        List<Pet> listOfSelectedPets = new ArrayList<Pet>();

        for (Pet pet : mapOfPets.values()) {
            if (pet.getName().toLowerCase().contains(queryString.toLowerCase())) {
                listOfSelectedPets.add(pet);
            }
        }
        return listOfSelectedPets;
    }
//
//    public static float findAverageAgeOfPets(final List<Pet> listOfPets) {
//        float total = 0;
//        for (Pet pet : listOfPets) {
//            total += pet.getAge();
//        }
//        return total / listOfPets.size();
//    }
//
//    public static void getInfoAboutPets(List<Pet> listOfPets, InfoFinder petFinder) {
//
//        petFinder.getInfo(listOfPets);
//
//    }
//
//    public interface InfoFinder {
//        float getInfo(List<Pet> listOfPets);
//    }
}
