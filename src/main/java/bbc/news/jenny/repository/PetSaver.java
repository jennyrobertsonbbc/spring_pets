package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetSaver {

    @Autowired
    private DBQuery dbQuery;

    public void save(List<Pet> listOfPets) {


        String query = "";

        for (Pet pet : listOfPets) {

            if (pet.getPetId() == null) {
                query = String.format("INSERT into pets " +
                                "(owner_id, pet_name ,pet_age,pet_health ,pet_type_id) " +
                                "VALUES('%d','%s','%d','%d','%d');",
                        pet.getOwnerId(), pet.getName(), pet.getAge(), pet.getHealth(), pet.getPetTypeId()
                );
                System.out.println(query);


            } else {

                query = String.format("UPDATE pets SET " +
                                "owner_id = '%d'," +
                                "pet_name = '%s'," +
                                "pet_age = '%d'," +
                                "pet_health = '%d'," +
                                "pet_type_id  = '%d'" +
                                " WHERE pet_id = '%d';",
                        pet.getOwnerId(), pet.getName(), pet.getAge(), pet.getHealth(), pet.getPetTypeId(), pet.getPetId()
                );
                //System.out.println(query);



            }
            dbQuery.sendUpdateQuery(query);

        }
        System.out.println("List of pets saved to DB");
    }

}
