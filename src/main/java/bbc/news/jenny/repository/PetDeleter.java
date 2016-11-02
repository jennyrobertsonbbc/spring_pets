package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PetDeleter {
    @Autowired
    DBQuery dbQuery;

    public void delete(Pet pet) {


        String query = "";

//        query = String.format("UPDATE pets SET " +
//                        "owner_id = '%d'," +
//                        "pet_name = '%s'," +
//                        "pet_age = '%d'," +
//                        "pet_health = '%d'," +
//                        "pet_type_id  = '%d'" +
//                        " WHERE pet_id = '%d';",
//                pet.getOwnerId(), pet.getName(), pet.getAge(), pet.getHealth(), pet.getPetTypeId(), pet.getPetId()
//        );


        query = String.format("DELETE FROM pets WHERE pet_id = '%d';", pet.getPetId());
        //System.out.println(query);

        dbQuery.sendUpdateQuery(query);


        System.out.println("Pet deleted");
    }

}
