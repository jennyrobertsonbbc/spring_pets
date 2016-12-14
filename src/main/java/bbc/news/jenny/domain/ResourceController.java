package bbc.news.jenny.domain;

import bbc.news.jenny.repository.PetRepository;
import bbc.news.jenny.repository.PetTypeRepository;
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
    @Autowired
    private PetTypeRepository petTypeRepository;

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
        List<PetType> listOfPetTypes = petTypeRepository.load();
        System.out.println("here:");

        System.out.println(listOfPetTypes.toString());

        PetType petType = null;

        for (PetType petTypeSearch : listOfPetTypes) {
            if (petTypeSearch.getId() == petTypeId) {
                petType = petTypeSearch;
                break;
            }
        }
        Pet petToAdd = new Pet(ownerId, name, age, health, petType);

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

    @RequestMapping(value = "pets/types", method = RequestMethod.GET)
    public List<PetType> getPetTypes() {
        return petTypeRepository.load();
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

