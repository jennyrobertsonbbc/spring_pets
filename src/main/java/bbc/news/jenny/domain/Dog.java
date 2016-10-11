package bbc.news.jenny.domain;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class Dog extends AbstractPet {
    //only we can do it
    private boolean goodDog;

    public Dog(Integer petId, Integer ownerId, String name, Integer age, Integer hunger, Integer petTypeId, boolean goodDog) {
        super(petId, ownerId, name, age, hunger, petTypeId);
        this.goodDog = goodDog;
    }

    public Dog(Integer ownerId, String name, Integer age, Integer hunger, Integer petTypeId, boolean goodDog) {
        super(ownerId, name, age, hunger, petTypeId);
        this.goodDog = goodDog;
    }

    public void speak(Integer numberOfTimes){
        for(int i = 0;i < numberOfTimes; i++){
            System.out.println("Woof! ");
        }

    }


}
