package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PetSaver {

//    @Autowired
//    private DBQuery dbQuery;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(List<Pet> listOfPets) {


        String sql = "";
        MapSqlParameterSource parameters = new MapSqlParameterSource();

        for (Pet pet : listOfPets) {

            if (pet.getPetId() == null) {

                sql = "INSERT into pets " +
                        "(owner_id, pet_name ,pet_age,pet_health ,pet_type_id) " +
                        "VALUES(:owner_id,:pet_name,:pet_age,:pet_health,:pet_type_id);";

                parameters.addValue("owner_id", pet.getOwnerId());
                parameters.addValue("pet_name", pet.getName());
                parameters.addValue("pet_age", pet.getAge());
                parameters.addValue("pet_health", pet.getHealth());
                parameters.addValue("pet_type_id", pet.getPetTypeId());

            }


             else {


                sql = "UPDATE pets SET " +
                        "owner_id = :owner_id," +
                        "pet_name = :pet_name," +
                        "pet_age = :pet_age," +
                        "pet_health = :pet_health," +
                        "pet_type_id  = :pet_type_id" +
                        " WHERE pet_id = :pet_id;";


                parameters.addValue("owner_id", pet.getOwnerId());
                parameters.addValue("pet_name", pet.getName());
                parameters.addValue("pet_age", pet.getAge());
                parameters.addValue("pet_health", pet.getHealth());
                parameters.addValue("pet_type_id", pet.getPetTypeId());
                parameters.addValue("pet_id", pet.getPetId());

            }
            //dbQuery.sendUpdateQuery(sql);
            namedParameterJdbcTemplate.update(sql, parameters);


        }
        System.out.println("List of pets saved to DB");
    }

}
