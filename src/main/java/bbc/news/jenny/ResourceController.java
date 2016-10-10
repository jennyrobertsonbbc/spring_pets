package bbc.news.jenny;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.*;

@RestController
public class ResourceController {


    //make some pets
    private List<Pet> thePets = new ArrayList<Pet>();



    private static final String template = "Hello, %s!";

    public void initList(){
        thePets.add(new Pet("Angus"));
    }

    //these are all gets
    @RequestMapping("/hello")
    public String returnStringFromURL(){
        return "hello";
    }

    @RequestMapping("/hello/{name}")
    public String returnStringFromURL2(@PathVariable String name){
        return "hello " + name;
    }

    @RequestMapping("pets")
    public List<Pet> returnListOfPets(){
        return thePets;
    }

    @RequestMapping("pets/{name}")
    public Pet returnPetByName(@PathVariable String name){
        for(Pet pet : thePets){
            if (pet.name.equals(name)){
                return pet;
            }

        }
        return null;
    }

    @RequestMapping(value = "pets/new/{name}", method = RequestMethod.GET)
    public Pet makeNewPet(@PathVariable String name){
        thePets.add(new Pet(name));

        return thePets.get(thePets.size()-1);
    }



    //***POST
    @RequestMapping(value="/test",method = RequestMethod.POST)
    public String displayPetFromBody(@RequestBody Pet pet){
        return pet.name;
    }

    @RequestMapping(value="/text",method = RequestMethod.POST)
    public String displayTextFromBody(@RequestBody String cheese){
        return cheese;
    }







}
