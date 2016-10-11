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
    //private List<PetType> listOfPetTypes =


    //these are all gets
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String returnStringFromURL() {
        return "hello";
    }

    @RequestMapping(value = "/hello/{forename}/{surname}", method = RequestMethod.GET)
    public String returnStringFromURL2(@PathVariable String forename, @PathVariable String surname) {
        return "hello" + forename + surname;
    }

    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public List<Pet> returnListOfPets() {
        listOfPets = petRepository.load();
        System.out.println(listOfPets);
        return listOfPets;
    }

    //TODO make Mr. Pompadoor work with this:

    @RequestMapping(value = "pets/{name}", method = RequestMethod.GET)
    public Pet returnPetByName(@PathVariable String name) {
        listOfPets = petRepository.load();
        return findPetFromListByName(listOfPets,name);
    }

    //todo Make it so you can say the word for the animal instead of the number
    //todo make it so it inserts it to the database, (which generates the correct petid)
    @RequestMapping(value = "pets/new/{ownerId}/{name}/{age}/{hunger}/{petTypeId}", method = RequestMethod.GET)
    public Pet makeNewPet(@PathVariable Integer ownerId, @PathVariable String name, @PathVariable Integer age,
                          @PathVariable Integer hunger, @PathVariable Integer petTypeId) {

        listOfPets = petRepository.load();

        switch (petTypeId) {
            case 1:
                listOfPets.add(new GuineaPig(ownerId, name, age, hunger, petTypeId));
                break;
            case 2:
                listOfPets.add(new Cat(ownerId, name, age, hunger, petTypeId, 5));
                break;
            case 3:
                listOfPets.add(new Pig(ownerId, name, age, hunger, petTypeId));
                break;
            case 4:
                listOfPets.add(new Dog(ownerId, name, age, hunger, petTypeId, true));
                break;
        }

        petRepository.save(listOfPets);
        listOfPets = petRepository.load();

        return listOfPets.get(listOfPets.size() - 1);
    }

    @RequestMapping(value = "pets/{name}/feed/{amount}/{foodType}", method = RequestMethod.GET)
    public String feedPet(@PathVariable String name, @PathVariable Integer amount, @PathVariable String foodType) {
        listOfPets = petRepository.load();
        String output;
        switch (foodType) {
            case "beef":
            case "Beef":
                PetFeederBeef petFeederBeef = new PetFeederBeef();
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
        petRepository.save(listOfPets);
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

//    //todo Make this work from database, but then the extractor will still be using a case statement so whats the point
//    public String getTypeNameFromTypeId(Integer petTypeId){
//        switch (petTypeId) {
//            case 1://guineapig
//                return "Guinea Pig";
//            case 2://cat
//                return "Cat";
//            case 3://pig
//                return "Pig";
//            case 4://dog
//                return "Dog";
//            default:
//                return null;
//        }
//
//    }



}
