package bbc.news.jenny.domain;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class Pig extends AbstractPet {
    //only we can do it

    public Pig(int petId, int ownerId, String name, int age, int hunger, int petTypeId) {
        super(petId, ownerId, name, age, hunger, petTypeId);
    }

    public Pig(int ownerId, String name, int age, int hunger, int petTypeId) {
        super(ownerId, name, age, hunger, petTypeId);
    }

    public void speak(int numberOfTimes){
        for(int i = 0;i < numberOfTimes; i++){
            System.out.println("Oink! ");
        }

    }


}
