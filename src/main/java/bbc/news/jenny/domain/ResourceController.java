package bbc.news.jenny.domain;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import bbc.news.jenny.repository.PetRepository;
import bbc.news.jenny.utils.PetUtils;
import bbc.news.jenny.workflow.PetFeederBeef;
import bbc.news.jenny.workflow.PetFeederHam;

@RestController
public class ResourceController {

    @Autowired
    private PetRepository petRepository;


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
        return petRepository.load();
    }

    //TODO make Mr. Pompadoor work with this:

    @RequestMapping(value = "pets/{name}", method = RequestMethod.GET)
    public Pet returnPetByName(@PathVariable String name) {
        List<Pet> listOfPets = petRepository.load();
        return PetUtils.findPetFromListByName(listOfPets, name);
    }

    //todo Make it so you can say the word for the animal instead of the number
    @RequestMapping(value = "pets/new/{ownerId}/{name}/{age}/{health}/{petTypeId}", method = RequestMethod.GET)
    public Pet makeNewPet(@PathVariable Integer ownerId, @PathVariable String name, @PathVariable Integer age,
                          @PathVariable Integer health, @PathVariable Integer petTypeId) {

        List<Pet> listOfPets = petRepository.load();

        AbstractPet petToAdd = null;

        switch (petTypeId) {
            case 1:
                petToAdd = new GuineaPig(ownerId, name, age, health, petTypeId);
                break;
            case 2:
                petToAdd = new Cat(ownerId, name, age, health, petTypeId, 5);
                break;
            case 3:
                petToAdd = new Pig(ownerId, name, age, health, petTypeId);
                break;
            case 4:
                petToAdd = new Dog(ownerId, name, age, health, petTypeId, true);
                break;
        }
        if(petToAdd == null) return null;

        listOfPets.add(petToAdd);

        petRepository.save(listOfPets);

        //must be loaded from database in order to display newly created petId
        listOfPets = petRepository.load();
        return findPetFromListByName(listOfPets,petToAdd.getName());
    }

    @RequestMapping(value = "pets/{name}/feed/{amount}/{foodType}", method = RequestMethod.GET)
    public Integer feedPet(@PathVariable String name, @PathVariable Integer amount, @PathVariable String foodType) {
        List<Pet> listOfPets = petRepository.load();
        Integer output;
        switch (foodType.toLowerCase()) {
            case "beef":
                PetFeederBeef petFeederBeef = new PetFeederBeef();
                output = petFeederBeef.feed(PetUtils.findPetFromListByName(listOfPets, name), amount);
                break;
            case "ham":
                PetFeederHam petFeederHam = new PetFeederHam();
                output = petFeederHam.feed(PetUtils.findPetFromListByName(listOfPets, name), amount);
                break;
            default:
                output = null;
        }
        petRepository.save(listOfPets);
        return output;
        //todo make the feeder return the new health and use that to set the css width

    }

    @RequestMapping(value = "pets/{name}/delete", method = RequestMethod.GET)
    public List<Pet> deletePet(@PathVariable String name) {
        List<Pet> listOfPets = petRepository.load();

        Pet pet = PetUtils.findPetFromListByName(listOfPets, name);

        petRepository.delete(pet);
        listOfPets = petRepository.load();


        return listOfPets;

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
        System.out.println("pet name from URL: " + petName);
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

