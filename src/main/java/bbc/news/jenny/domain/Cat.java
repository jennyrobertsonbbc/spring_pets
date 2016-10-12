package bbc.news.jenny.domain;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class Cat extends AbstractPet {
    private Integer number_of_whiskers;

    public Cat(Integer petId, Integer ownerId, String name, Integer age, Integer hunger, Integer petTypeId, Integer number_of_whiskers) {
        super(petId, ownerId, name, age, hunger, petTypeId);
        this.number_of_whiskers = number_of_whiskers;
    }

    public Cat(Integer ownerId, String name, Integer age, Integer hunger, Integer petTypeId, Integer number_of_whiskers) {
        super(ownerId, name, age, hunger, petTypeId);
        this.number_of_whiskers = number_of_whiskers;
    }

    public void speak(Integer numberOfTimes){
        for(int i = 0;i < numberOfTimes; i++){
            System.out.println("Meow! ");
        }
        System.out.println("");

    }
}
