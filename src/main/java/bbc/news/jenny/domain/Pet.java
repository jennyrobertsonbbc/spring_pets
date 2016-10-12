package bbc.news.jenny.domain;

/**
 * Created by roberj78 on 30/09/2016.
 */
public interface Pet {

    public Integer getHunger();

    public void setHunger(Integer hunger);

    public String getName();

    public void setName(String name);

    public Integer getAge();

    public void setAge(Integer age);

    public Integer getPetId();

    public void setPetId(Integer petId);

    public Integer getOwnerId();

    public void setOwnerId(Integer ownerId);

    public Integer getPetTypeId();

    public void setPetTypeId(Integer petTypeId);

    public void speak(Integer numberOfTimes);


}
