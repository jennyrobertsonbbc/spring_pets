package bbc.news.jenny.domain;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class Pig extends AbstractPet {
    //only we can do it

    public Pig(Integer petId, Integer ownerId, String name, Integer age, Integer hunger, Integer petTypeId) {
        super(petId, ownerId, name, age, hunger, petTypeId);
    }

    public Pig(Integer ownerId, String name, Integer age, Integer hunger, Integer petTypeId) {
        super(ownerId, name, age, hunger, petTypeId);
    }

    public void speak(Integer numberOfTimes){
        for(int i = 0;i < numberOfTimes; i++){
            System.out.println("Oink! ");
        }

    }


}
