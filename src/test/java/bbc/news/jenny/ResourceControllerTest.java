package bbc.news.jenny;

import bbc.news.jenny.domain.*;
import org.junit.Test;
import bbc.news.jenny.repository.PetRepository;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class ResourceControllerTest {

    ResourceController resourceController = new ResourceController();
    PetRepository petRepository = new PetRepository();

    @Test
    public void returnListOfPetsTest(){
        List<Pet> listOfPets = petRepository.load();
        assertEquals(listOfPets, resourceController.returnListOfPets());
    }

    @Test
    public void returnPetByNameTest() {

        List<Pet> listOfPets = petRepository.load();
        Pet pet = listOfPets.get(listOfPets.size()-1);

        assertEquals(pet, resourceController.returnPetByName(pet.getName()));
    }

//    @Test
//    public void makeNewPetTest(){
//        Pet expectedPet = new GuineaPig(4,"test pet name",3,45,1);
//        Pet returnedPet = resourceController.makeNewPet(4,"test pet name",3,45,1);
//
//        assertEquals(expectedPet,returnedPet);
//    }
}
