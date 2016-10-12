package bbc.news.jenny;

import bbc.news.jenny.domain.*;
import org.junit.Test;
import repository.PetRepository;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ResourceControllerTest {

    @Test
    public void findPetFromListByNameTest() {

        ResourceController resourceController = new ResourceController();
        PetRepository petRepository = new PetRepository();

        List<Pet> listOfPets;
        listOfPets = petRepository.load();

        Pet pet = listOfPets.get(listOfPets.size()-1);


        assertEquals(pet, resourceController.returnPetByName(pet.getName()));

    }
}
