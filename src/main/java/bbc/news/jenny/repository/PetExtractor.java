package bbc.news.jenny.repository;

import bbc.news.jenny.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PetExtractor {

//    @Autowired
//    private DBQuery dbQuery;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public List<Pet> extract() {
        String sql = "SELECT * FROM pets ORDER BY pet_id ASC;";

        return namedParameterJdbcTemplate.query(sql, new PetRowMapper());
    }

    public class PetRowMapper implements RowMapper<Pet> {


        @Override
        public Pet mapRow(ResultSet resultSet, int rowNum) throws SQLException {

            Integer petId = resultSet.getInt("pet_id");
            Integer ownerId = resultSet.getInt("owner_id");
            String petName = resultSet.getString("pet_name");
            Integer petAge = resultSet.getInt("pet_age");
            Integer petHealth = resultSet.getInt("pet_health");
            Integer petTypeId = resultSet.getInt("pet_type_id");


            switch (petTypeId) {
                case 1://guineapig
                    return new GuineaPig(petId, ownerId, petName, petAge, petHealth, petTypeId);
                case 2://cat
                    return new Cat(petId, ownerId, petName, petAge, petHealth, petTypeId, 100);
                case 3://pig
                    return new Pig(petId, ownerId, petName, petAge, petHealth, petTypeId);
                case 4://dog
                    return new Dog(petId, ownerId, petName, petAge, petHealth, petTypeId, true);
            }
            return null;
        }
    }

}
