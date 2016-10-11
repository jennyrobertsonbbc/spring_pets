package bbc.news.jenny.domain;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class Dog extends AbstractPet {
    //only we can do it
    private boolean goodDog;

    public Dog(int petId, int ownerId, String name, int age, int hunger, int petTypeId, boolean goodDog) {
        super(petId, ownerId, name, age, hunger, petTypeId);
        this.goodDog = goodDog;
    }

    public Dog(int ownerId, String name, int age, int hunger, int petTypeId, boolean goodDog) {
        super(ownerId, name, age, hunger, petTypeId);
        this.goodDog = goodDog;
    }

    public void speak(int numberOfTimes){
        for(int i = 0;i < numberOfTimes; i++){
            System.out.println("Woof! ");
        }

    }


}
