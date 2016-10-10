package bbc.news.jenny.domain;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.*;
import repository.OwnerRepository;
import repository.PetRepository;
import workflow.PetFeederBeef;
import workflow.PetFeederHam;

@RestController
public class ResourceController {


    private PetRepository petRepository = new PetRepository();
    private OwnerRepository ownerRepository = new OwnerRepository();

    //Load from database
    private List<Pet> listOfPets = petRepository.load();
    private List<Owner> listOfOwners = ownerRepository.load();


    //these are all gets
    @RequestMapping("/hello")
    public String returnStringFromURL() {
        return "hello";
    }

    @RequestMapping("/hello/{forename}/{surname}")
    public String returnStringFromURL2(@PathVariable String forename, @PathVariable String surname) {
        return "hello" + forename + surname;
    }

    @RequestMapping("pets")
    public List<Pet> returnListOfPets() {
        return listOfPets;
    }

    //TODO make Mr. Pompadoor work with this:

    @RequestMapping("pets/{name}")
    public Pet returnPetByName(@PathVariable String name) {
        return findPetFromListByName(listOfPets,name);
    }

    @RequestMapping(value = "pets/new/{ownerId}/{name}/{age}/{hunger}/{petTypeId}", method = RequestMethod.GET)
    public Pet makeNewPet(@PathVariable int ownerId, @PathVariable String name, @PathVariable int age,
                          @PathVariable int hunger, @PathVariable int petTypeId) {

        switch (petTypeId) {
            case 1:
                listOfPets.add(new GuineaPig(0, ownerId, name, age, hunger, petTypeId));
                break;
            case 2:
                listOfPets.add(new Cat(0, ownerId, name, age, hunger, petTypeId, 5));
                break;
            case 3:
                listOfPets.add(new Pig(0, ownerId, name, age, hunger, petTypeId));
                break;
            case 4:
                listOfPets.add(new Dog(0, ownerId, name, age, hunger, petTypeId, true));
                break;
        }

        return listOfPets.get(listOfPets.size() - 1);
    }

    @RequestMapping("pets/{name}/feed/{amount}/{foodType}")
    public String feedPet(@PathVariable String name, @PathVariable int amount, @PathVariable String foodType) {
        String output;
        switch (foodType) {
            case "beef":
            case "Beef":
                PetFeederBeef petFeederBeef = new PetFeederBeef();


                //TODO fix this too
                output = petFeederBeef.feed(findPetFromListByName(listOfPets,name), amount);
                break;
            case "ham":
            case "Ham":
                PetFeederHam petFeederHam = new PetFeederHam();
                output = petFeederHam.feed(findPetFromListByName(listOfPets,name), amount);
                break;
            default:
                output = "";
        }
        return output;

    }


    //***POST
    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String displayPetFromBody(@RequestBody Pet pet) {
        return pet.getName();
    }

    @RequestMapping(value = "/text", method = RequestMethod.POST)
    public String displayTextFromBody(@RequestBody String cheese) {
        return cheese;
    }

    private Pet findPetFromListByName(List<Pet> listOfPets, String petName) {
        for (Pet pet : listOfPets) {
            if (pet.getName().equals(petName)) {
                return pet;
            }
        }
        return null;
    }


}
