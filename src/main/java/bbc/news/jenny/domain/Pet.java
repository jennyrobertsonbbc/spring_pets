package bbc.news.jenny.domain;

/**
 * Created by roberj78 on 30/09/2016.
 */
public interface Pet {

    public int getHunger();

    public void setHunger(int hunger);

    public String getName();

    public void setName(String name);

    public int getAge();

    public void setAge(int age);

    public int getPetId();

    public void setPetId(int petId);

    public int getOwnerId();

    public void setOwnerId(int ownerId);

    public int getPetTypeId();

    public void setPetTypeId(int petTypeId);

    public void speak(int numberOfTimes);
}
