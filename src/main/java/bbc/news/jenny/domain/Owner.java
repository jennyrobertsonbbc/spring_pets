package bbc.news.jenny.domain;

import java.util.List;

/**
 * Created by roberj78 on 03/10/2016.
 */
public class Owner {
    private Integer ownerId;
    private String name;
    private Integer age;
    private List<Pet> petsOwned;

    public Owner(Integer ownerID, String name, Integer age) {
        this.ownerId = ownerID;
        this.name = name;
        this.age = age;
    }

    public Integer getOwnerId() {
        return ownerId;
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

    public List<Pet> getPetsOwned() {
        return petsOwned;
    }

    public void setPetsOwned(List<Pet> petsOwned) {
        this.petsOwned = petsOwned;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "ownerID=" + ownerId +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", petsOwned=" + petsOwned +
                '}';
    }
}
