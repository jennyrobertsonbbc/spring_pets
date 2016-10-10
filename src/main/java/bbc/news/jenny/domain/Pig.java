package bbc.news.jenny.domain;

/**
 * Created by roberj78 on 30/09/2016.
 */
public class Pig implements Pet {

    private int petId;
    private int ownerId;
    private String name;
    private int age;
    private int hunger;
    private int petTypeId;

    public Pig(int petId, int ownerId, String name, int age, int hunger, int petTypeId) {
        this.petId = petId;
        this.ownerId = ownerId;
        this.name = name;
        this.age = age;
        this.hunger = hunger;
        this.petTypeId = petTypeId;
    }

    public void speak(int numberOfTimes) {
        for (int i = 0; i < numberOfTimes; i++) {
            System.out.println("Oink! ");
        }

    }

    public int getPetId() {
        return petId;
    }

    public void setPetId(int petId) {
        this.petId = petId;
    }

    public int getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(int ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHunger() {
        return hunger;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
    }

    public int getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(int petTypeId) {
        this.petTypeId = petTypeId;
    }

    @Override
    public String toString() {
        return "Pig{" +
                "petId=" + petId +
                ", ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hunger=" + hunger +
                ", petTypeId=" + petTypeId +
                '}';
    }
}
