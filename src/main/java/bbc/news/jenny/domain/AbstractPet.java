package bbc.news.jenny.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by roberj78 on 29/09/2016.
 */
abstract class AbstractPet implements Pet{
    private int petId;
    private int ownerId;
    private String name;
    private int age;
    private int hunger;
    private int petTypeId;


    public AbstractPet(int petId, int ownerId, String name, int age, int hunger, int petTypeId) {
        this.petId = petId;
        this.ownerId = ownerId;
        this.name = name;
        this.age = age;
        this.hunger = hunger;
        this.petTypeId = petTypeId;
    }

    public AbstractPet(int ownerId, String name, int age, int hunger, int petTypeId) {
        this.ownerId = ownerId;
        this.name = name;
        this.age = age;
        this.hunger = hunger;
        this.petTypeId = petTypeId;
    }

    public void setHunger(int hunger) {
        this.hunger = hunger;
        System.out.printf("%s's hunger is now %d.\n\n",this.name,getHunger());
    }

    public AbstractPet(){}


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

    public int getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(int petTypeId) {
        this.petTypeId = petTypeId;
    }

    @Override
    public String toString() {
        return "AbstractPet{" +
                "petId=" + petId +
                ", ownerId=" + ownerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", hunger=" + hunger +
                ", petTypeId=" + petTypeId +
                '}';
    }

}
