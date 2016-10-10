package bbc.news.jenny.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;
import workflow.PetFeederBeef;
import workflow.PetFeederHam;

@RestController
public class ResourceController {


    //make some pets
    private List<Pet> thePets = new ArrayList<Pet>();



    private static final String template = "Hello, %s!";


    //these are all gets
    @RequestMapping("/hello")
    public String returnStringFromURL(){
        return "hello";
    }

    @RequestMapping("/hello/{forename}/{surname}")
    public String returnStringFromURL2(@PathVariable String forename, @PathVariable String surname){
        return "hello" + forename + surname;
    }

    @RequestMapping("pets")
    public List<Pet> returnListOfPets(){
        return thePets;
    }

    @RequestMapping("pets/{name}")
    public Pet returnPetByName(@PathVariable String name){
        for(Pet pet : thePets){
            if (pet.getName().equals(name)){
                return pet;
            }

        }
        return null;
    }

    @RequestMapping(value = "pets/new/{ownerId}/{name}/{age}/{hunger}/{petTypeId}", method = RequestMethod.GET)
    public Pet makeNewPet(@PathVariable int ownerId, @PathVariable String name, @PathVariable int age,
                          @PathVariable int hunger, @PathVariable int petTypeId){

        switch (petTypeId){
            case 1: thePets.add(new GuineaPig(0,ownerId,name,age,hunger,petTypeId));
                break;
            case 2: thePets.add(new Cat(0,ownerId,name,age,hunger,petTypeId,5));
                break;
            case 3: thePets.add(new Pig(0,ownerId,name,age,hunger,petTypeId));
                break;
            case 4: thePets.add(new Dog(0,ownerId,name,age,hunger,petTypeId,true));
                break;
        }

        return thePets.get(thePets.size()-1);
    }
    @RequestMapping("pets/{name}/feed/{amount}/{foodType}")
    public String feedPet(@PathVariable String name, @PathVariable int amount, @PathVariable String foodType){
        String output;
        switch (foodType){
            case "beef":
            case "Beef":
                PetFeederBeef petFeederBeef = new PetFeederBeef();
                output = petFeederBeef.feed(thePets.get(0),amount);
                break;
            case "ham":
            case "Ham":
                PetFeederHam petFeederHam = new PetFeederHam();
                output = petFeederHam.feed(thePets.get(0),amount);
                break;
            default:
                output = "";
        }
        return output;

    }



    //***POST
    @RequestMapping(value="/test",method = RequestMethod.POST)
    public String displayPetFromBody(@RequestBody Pet pet){
        return pet.getName();
    }

    @RequestMapping(value="/text",method = RequestMethod.POST)
    public String displayTextFromBody(@RequestBody String cheese){
        return cheese;
    }







}
