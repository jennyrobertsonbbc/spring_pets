package bbc.news.jenny.domain;

/**
 * Created by roberj78 on 29/09/2016.
 */
public class GuineaPig extends AbstractPet {
    public GuineaPig(Integer petId, Integer ownerId, String name, Integer age, Integer health, Integer petTypeId) {
        super(petId, ownerId, name, age, health, petTypeId);
    }

    public GuineaPig(Integer ownerId, String name, Integer age, Integer health, Integer petTypeId) {
        super(ownerId, name, age, health, petTypeId);
    }

    public void speak(Integer numberOfTimes){
        for(int i = 0;i < numberOfTimes; i++){
            System.out.println("ee");
        }

    }


}
