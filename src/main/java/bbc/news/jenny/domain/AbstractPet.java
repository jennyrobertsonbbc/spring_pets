package bbc.news.jenny.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Created by roberj78 on 29/09/2016.
 */
abstract class AbstractPet implements Pet{
    private Integer petId;
    private Integer ownerId;
    private String name;
    private Integer age;
    private Integer hunger;
    private Integer petTypeId;


    public AbstractPet(Integer petId, Integer ownerId, String name, Integer age, Integer hunger, Integer petTypeId) {
        this.petId = petId;
        this.ownerId = ownerId;
        this.name = name;
        this.age = age;
        this.hunger = hunger;
        this.petTypeId = petTypeId;
    }

    public AbstractPet(Integer ownerId, String name, Integer age, Integer hunger, Integer petTypeId) {
        this.ownerId = ownerId;
        this.name = name;
        this.age = age;
        this.hunger = hunger;
        this.petTypeId = petTypeId;
    }

    public void setHunger(Integer hunger) {
        this.hunger = hunger;
        System.out.printf("%s's hunger is now %d.\n\n",this.name,getHunger());
    }

    public AbstractPet(){}


    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHunger() {
        return hunger;
    }

    public Integer getPetTypeId() {
        return petTypeId;
    }

    public void setPetTypeId(Integer petTypeId) {
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
