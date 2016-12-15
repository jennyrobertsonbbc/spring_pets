package bbc.news.jenny.repository;

import bbc.news.jenny.domain.PetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PetTypeSaver {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void save(PetType petType) {
//
//
//        String sql = "";
//        MapSqlParameterSource parameters = new MapSqlParameterSource();
//
//        for (PetType petType : listOfPetTypes) {
//
//            if (petType.getPetId() == null) {
//
//                sql = "INSERT into pets " +
//                        "(owner_id, pet_name ,pet_age,pet_health ,pet_type_id) " +
//                        "VALUES(:owner_id,:pet_name,:pet_age,:pet_health,:pet_type_id);";
//
//                parameters.addValue("owner_id", pet.getOwnerId());
//                parameters.addValue("pet_name", pet.getName());
//                parameters.addValue("pet_age", pet.getAge());
//                parameters.addValue("pet_health", pet.getHealth());
//                parameters.addValue("pet_type_id", pet.getPetType().getId());
//
//            } else {
//
//
//                sql = "UPDATE pets SET " +
//                        "owner_id = :owner_id," +
//                        "pet_name = :pet_name," +
//                        "pet_age = :pet_age," +
//                        "pet_health = :pet_health," +
//                        "pet_type_id  = :pet_type_id" +
//                        " WHERE pet_id = :pet_id;";
//
//
//                parameters.addValue("owner_id", pet.getOwnerId());
//                parameters.addValue("pet_name", pet.getName());
//                parameters.addValue("pet_age", pet.getAge());
//                parameters.addValue("pet_health", pet.getHealth());
//                parameters.addValue("pet_type_id", pet.getPetType().getId());
//                parameters.addValue("pet_id", pet.getPetId());
//
//            }
//            namedParameterJdbcTemplate.update(sql, parameters);
//
//
//        }
//        System.out.println("List of pets saved to DB");
    }

}
