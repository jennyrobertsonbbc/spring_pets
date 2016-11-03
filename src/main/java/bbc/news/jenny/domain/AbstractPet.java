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
    private Integer health;
    private Integer petTypeId;


    public AbstractPet(Integer petId, Integer ownerId, String name, Integer age, Integer health, Integer petTypeId) {
        this.petId = petId;
        this.ownerId = ownerId;
        this.name = name;
        this.age = age;
        this.health = health;
        this.petTypeId = petTypeId;


    }

    public AbstractPet(Integer ownerId, String name, Integer age, Integer health, Integer petTypeId) {
        this.ownerId = ownerId;
        this.name = name;
        this.age = age;
        this.health = health;
        this.petTypeId = petTypeId;
    }

    public void setHealth(Integer health) {
        this.health = health;
        System.out.printf("%s's health is now %d.\n\n",this.name,getHealth());
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

    public Integer getHealth() {
        return health;
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
                ", health=" + health +
                ", petTypeId=" + petTypeId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractPet that = (AbstractPet) o;

        if (petId != null ? !petId.equals(that.petId) : that.petId != null) return false;
        if (ownerId != null ? !ownerId.equals(that.ownerId) : that.ownerId != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (age != null ? !age.equals(that.age) : that.age != null) return false;
        if (health != null ? !health.equals(that.health) : that.health != null) return false;
        return petTypeId != null ? petTypeId.equals(that.petTypeId) : that.petTypeId == null;

    }

    @Override
    public int hashCode() {
        return 0;
    }
}
