package bbc.news.jenny;

import bbc.news.jenny.domain.Cat;
import bbc.news.jenny.domain.Pet;
import bbc.news.jenny.utils.PetUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PetUtilsTest {
    @Test
    public void averageAgeOfPetsTest(){

        List<Pet> listOfPets = new ArrayList<Pet>();

        listOfPets.add(new Cat(1,"Bob", 5,50,1,50));
        listOfPets.add(new Cat(1,"Bob", 10,50,1,50));
        listOfPets.add(new Cat(1,"Bob", 0,50,1,50));
        listOfPets.add(new Cat(1,"Bob", 100,50,1,50));

        System.out.println(PetUtils.findAverageAgeOfPets(listOfPets));

        assert (PetUtils.findAverageAgeOfPets(listOfPets) == 28.75f);

        System.out.println(new Cat(1,"Bob", 5,50,1,50));
    }

    @Test
    public void findPetsAnonymousTest(){

        List<Pet> listOfPets = new ArrayList<Pet>();

        listOfPets.add(new Cat(1,"Bob", 5,50,1,50));
        listOfPets.add(new Cat(1,"Bob", 10,50,1,50));
        listOfPets.add(new Cat(1,"Bob", 0,50,1,50));
        listOfPets.add(new Cat(1,"Bob", 100,50,1,50));

      PetUtils.getInfoAboutPets(listOfPets, new PetUtils.InfoFinder() {
            @Override
            public float getInfo(List<Pet> listOfPets) {

                float total = 0;
                for (Pet pet : listOfPets) {
                    total += pet.getAge();
                }
                return total / listOfPets.size();
            }
        });



    }


}

