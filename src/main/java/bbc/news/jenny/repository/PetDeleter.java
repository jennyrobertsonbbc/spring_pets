package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Pet;

/**
 * Created by roberj78 on 07/10/2016.
 */
public class PetDeleter {
    public void delete(Pet pet) {

        DBQuery dbQuery = new DBQuery();
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
