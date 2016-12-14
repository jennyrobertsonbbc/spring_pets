package bbc.news.jenny.domain;

import bbc.news.jenny.repository.PetRepository;
import bbc.news.jenny.utils.PetUtils;
import bbc.news.jenny.workflow.PetFeederBeef;
import bbc.news.jenny.workflow.PetFeederHam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ResourceController {

    @Autowired
    private PetRepository petRepository;

    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public List<Pet> returnListOfPets() {
        return petRepository.load();
    }

    @RequestMapping(value = "pets/{name}", method = RequestMethod.GET)
    public Pet returnPetByName(@PathVariable String name) {
        List<Pet> listOfPets = petRepository.load();
        return PetUtils.findPetFromListByName(listOfPets, name);
    }

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
        if (petToAdd == null) return null;

        listOfPets.add(petToAdd);

        petRepository.save(listOfPets);

        //must be loaded from database in order to display newly created petId
        listOfPets = petRepository.load();
        return PetUtils.findPetFromListByName(listOfPets, petToAdd.getName());
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
    }

    @RequestMapping(value = "pets/{name}/delete", method = RequestMethod.GET)
    public List<Pet> deletePet(@PathVariable String name) {
        List<Pet> listOfPets = petRepository.load();

        Pet pet = PetUtils.findPetFromListByName(listOfPets, name);

        petRepository.delete(pet);
        listOfPets = petRepository.load();


        return listOfPets;

    }

    @RequestMapping(value = "pets/search/{queryString}", method = RequestMethod.GET)
    public List<Pet> searchForPet(@PathVariable String queryString) {
        List<Pet> listOfPets = petRepository.load();

        return PetUtils.findPetFromListByPartialName(listOfPets, queryString);

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


}

