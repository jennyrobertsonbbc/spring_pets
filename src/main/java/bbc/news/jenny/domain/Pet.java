package bbc.news.jenny.domain;

public class Pet{
    private Integer petId;
    private Owner owner;
    private String name;
    private Integer age;
    private Integer health;
    private PetType petType;


    public Pet(Integer petId, Owner owner, String name, Integer age, Integer health, PetType petType) {
        this.petId = petId;
        this.owner = owner;
        this.name = name;
        this.age = age;
        this.health = health;
        this.petType = petType;
    }

    public Pet(Owner owner, String name, Integer age, Integer health, PetType petType) {
        this.owner = owner;
        this.name = name;
        this.age = age;
        this.health = health;
        this.petType = petType;
    }

    public void setHealth(Integer health) {
        this.health = health;
        System.out.printf("%s's health is now %d.\n\n",this.name,getHealth());
    }

    public Pet(){}


    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public Owner getOwnerId() {
        return owner;
    }

    public void setOwnerId(Owner owner) {
        this.owner = owner;
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

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "petId=" + petId +
                ", owner=" + owner +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", health=" + health +
                ", petType=" + petType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pet pet = (Pet) o;

        if (petId != null ? !petId.equals(pet.petId) : pet.petId != null) return false;
        if (owner != null ? !owner.equals(pet.owner) : pet.owner != null) return false;
        if (name != null ? !name.equals(pet.name) : pet.name != null) return false;
        if (age != null ? !age.equals(pet.age) : pet.age != null) return false;
        if (health != null ? !health.equals(pet.health) : pet.health != null) return false;
        return petType != null ? petType.equals(pet.petType) : pet.petType == null;

    }

    @Override
    public int hashCode() {
        return 0;
    }


}
