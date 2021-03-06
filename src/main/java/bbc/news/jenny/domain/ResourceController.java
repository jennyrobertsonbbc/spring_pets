package bbc.news.jenny.domain;

import bbc.news.jenny.repository.PetRepository;
import bbc.news.jenny.repository.PetTypeRepository;
import bbc.news.jenny.utils.PetUtils;
import bbc.news.jenny.workflow.PetFeederBeef;
import bbc.news.jenny.workflow.PetFeederHam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ResourceController {

    @Autowired
    private PetRepository petRepository;
    @Autowired
    private PetTypeRepository petTypeRepository;

    @RequestMapping(value = "/pets", method = RequestMethod.GET)
    public Map<Integer, Pet> returnListOfPets() {
        return petRepository.load();
    }

    @RequestMapping(value = "pets/{name}", method = RequestMethod.GET)
    public Pet returnPetByName(@PathVariable String name) {
        Map<Integer, Pet> mapOfPets = petRepository.load();
        return PetUtils.findPetByName(mapOfPets, name);
    }

    @RequestMapping(value = "pets/new/{ownerId}/{name}/{age}/{health}/{petTypeId}", method = RequestMethod.GET)
    public Pet makeNewPet(@PathVariable Integer ownerId, @PathVariable String name, @PathVariable Integer age,
                          @PathVariable Integer health, @PathVariable Integer petTypeId) {


        Map<Integer, Pet> mapOfPets = petRepository.load();
        Map<Integer, PetType> mapOfPetTypes = petTypeRepository.load();


        Pet petToAdd = new Pet(ownerId, name, age, health, mapOfPetTypes.get(petTypeId));

        int newPetKey = petRepository.save(petToAdd);
        petToAdd.setPetId(newPetKey);

        mapOfPets.put(newPetKey, petToAdd);

        return petToAdd;
    }

    @RequestMapping(value = "pets/{petId}/feed/{amount}/{foodType}", method = RequestMethod.GET)
    public Integer feedPet(@PathVariable Integer petId, @PathVariable Integer amount, @PathVariable String foodType) {
        Map<Integer, Pet> mapOfPets = petRepository.load();
        Pet petToFeed = mapOfPets.get(petId);
        Integer output;
        switch (foodType.toLowerCase()) {
            case "beef":
                PetFeederBeef petFeederBeef = new PetFeederBeef();
                output = petFeederBeef.feed(petToFeed, amount);
                break;
            case "ham":
                PetFeederHam petFeederHam = new PetFeederHam();
                output = petFeederHam.feed(petToFeed, amount);
                break;
            default:
                output = null;
        }
        petRepository.save(petToFeed);
        return output;
    }

    @RequestMapping(value = "pets/{petId}/delete", method = RequestMethod.GET)
    public void deletePet(@PathVariable Integer petId) {
        Map<Integer, Pet> mapOfPets = petRepository.load();

        petRepository.delete(mapOfPets.get(petId));

    }

    @RequestMapping(value = "pets/search/{queryString}", method = RequestMethod.GET)
    public List<Pet> searchForPet(@PathVariable String queryString) {
        Map<Integer, Pet>  mapOfPets = petRepository.load();

        return PetUtils.findPetByPartOfName(mapOfPets, queryString);

    }

    @RequestMapping(value = "pets/types", method = RequestMethod.GET)
    public Map<Integer, PetType> getPetTypes() {
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

