package bbc.news.jenny.domain;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class Cat extends AbstractPet {
    private int number_of_whiskers;

    public Cat(int petId, int ownerId, String name, int age, int hunger, int petTypeId, int number_of_whiskers) {
        super(petId, ownerId, name, age, hunger, petTypeId);
        this.number_of_whiskers = number_of_whiskers;
    }

    public Cat(int ownerId, String name, int age, int hunger, int petTypeId, int number_of_whiskers) {
        super(ownerId, name, age, hunger, petTypeId);
        this.number_of_whiskers = number_of_whiskers;
    }

    public void speak(int numberOfTimes){
        for(int i = 0;i < numberOfTimes; i++){
            System.out.println("Meow! ");
        }
        System.out.println("");

    }
}
