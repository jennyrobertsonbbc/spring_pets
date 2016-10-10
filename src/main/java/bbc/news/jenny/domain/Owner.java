package bbc.news.jenny.domain;

import java.util.List;

/**
 * Created by roberj78 on 03/10/2016.
 */
public class Owner {
    private int ownerID;
    private String name;
    private int age;
    private List<Pet> petsOwned;

    public Owner(int ownerID, String name, int age) {
        this.ownerID = ownerID;
        this.name = name;
        this.age = age;
    }

    public int getOwnerID() {
        return ownerID;
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

    public List<Pet> getPetsOwned() {
        return petsOwned;
    }

    public void setPetsOwned(List<Pet> petsOwned) {
        this.petsOwned = petsOwned;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerID=" + ownerID +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", petsOwned=" + petsOwned +
                '}';
    }
}
