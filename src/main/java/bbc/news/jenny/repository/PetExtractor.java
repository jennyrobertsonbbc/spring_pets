package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Pet;
import bbc.news.jenny.domain.PetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class PetExtractor {

    @Autowired
    private PetTypeRepository petTypeRepository;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Map extract() {
        String sql = "SELECT * FROM pets ORDER BY pet_id ASC;";

        HashMap<Integer, Pet> mapOfPets = new HashMap<Integer, Pet>();

        PetType testPetType = new PetType("testType", 1000);
        Pet testPet = new Pet(3, "bobob", 5, 50, testPetType);

        Map<Integer, PetType> mapOfPetTypes = petTypeRepository.load();


        return namedParameterJdbcTemplate.query(sql, new ResultSetExtractor<Map>() {
            @Override
            public Map extractData(ResultSet resultSet) throws SQLException, DataAccessException {

                while (resultSet.next()) {
                    mapOfPets.put(resultSet.getInt("pet_id"), new Pet(
                            resultSet.getInt("pet_id"),
                            resultSet.getInt("owner_id"),
                            resultSet.getString("pet_name"),
                            resultSet.getInt("pet_age"),
                            resultSet.getInt("pet_health"),
                            mapOfPetTypes.get(resultSet.getInt("pet_type_id")))
                    );
                }
                return mapOfPets;
            }
        });
    }

}
