package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class PetSaver {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int save(Pet pet) {

        if (pet.getPetId() == null) {

            KeyHolder keyHolder = new GeneratedKeyHolder();

            String sql = "";
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            sql = "INSERT into pets " +
                    "(owner_id, pet_name ,pet_age,pet_health ,pet_type_id) " +
                    "VALUES(:owner_id,:pet_name,:pet_age,:pet_health,:pet_type_id);";

            parameters.addValue("owner_id", pet.getOwner().getOwnerId());
            parameters.addValue("pet_name", pet.getName());
            parameters.addValue("pet_age", pet.getAge());
            parameters.addValue("pet_health", pet.getHealth());
            parameters.addValue("pet_type_id", pet.getPetType().getId());

            namedParameterJdbcTemplate.update(sql, parameters, keyHolder);
            int newKey = (int) keyHolder.getKeys().get("pet_id");
            return newKey;
        } else {

            String sql = "";
            MapSqlParameterSource parameters = new MapSqlParameterSource();


            sql = "UPDATE pets SET " +
                    "owner_id = :owner_id," +
                    "pet_name = :pet_name," +
                    "pet_age = :pet_age," +
                    "pet_health = :pet_health," +
                    "pet_type_id  = :pet_type_id" +
                    " WHERE pet_id = :pet_id;";


            parameters.addValue("owner_id", pet.getOwner().getOwnerId());
            parameters.addValue("pet_name", pet.getName());
            parameters.addValue("pet_age", pet.getAge());
            parameters.addValue("pet_health", pet.getHealth());
            parameters.addValue("pet_type_id", pet.getPetType().getId());
            parameters.addValue("pet_id", pet.getPetId());

            namedParameterJdbcTemplate.update(sql, parameters);
            return 0;
        }
    }


}
