package bbc.news.jenny.repository;

import bbc.news.jenny.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class PetExtractor {

    @Autowired
    private PetTypeRepository petTypeRepository;
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

            List<PetType> listOfPetTypes = petTypeRepository.load();
            PetType petType = null;

            for (PetType petTypeSearch : listOfPetTypes) {
                if (petTypeSearch.getId() == petTypeId) {
                    petType = petTypeSearch;
                }
            }
            return new Pet(petId, ownerId, petName, petAge, petHealth, petType);
        }
    }

}
