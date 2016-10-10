package bbc.news.jenny;

import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//@RestController
public class HelloController {

    //make some pets
    private List<Pet> thePets = Arrays.asList(new Pet("Sax"),new Pet("Ophelia"), new Pet("Russell"));


    //** just returns spring boot
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }



    //*****hello/jenny, GETTING info from the url and outputting it
    @RequestMapping(value="/hello/{name}",method = RequestMethod.GET)
    public HelloMessage helloWorld(@PathVariable String name){
        HelloMessage message = new HelloMessage();
        message.message = "Hello " + name;
        return  message;
    }

    //***POST
    @RequestMapping(value="/test",method = RequestMethod.POST)
    public HelloMessage postHelloWorld(@RequestBody Pet pet){
        HelloMessage message = new HelloMessage();
        message.message = "Hello " + pet.name;
        return  message;
    }

    //***/pets , GETS the list of pets from the server and outputs them
    @RequestMapping(value="/pets",method = RequestMethod.GET)
    public List<Pet> pets() {
        return thePets;
    }


    @RequestMapping(value="/pet/{name}",method = RequestMethod.GET)
    public Pet pet(@PathVariable String name) {
        for(Pet pet : thePets) {
            if(pet.name.equals(name))
                return pet;
        }
        return null;
    }

    private static class HelloMessage {
        public String message;
    }

}