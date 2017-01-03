package bbc.news.jenny.repository;

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
public class PetTypeExtractor {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Map extract() {
        String sql = "SELECT * FROM pet_types;";

        HashMap<Integer, PetType> mapOfPetTypes = new HashMap<Integer, PetType>();

        return namedParameterJdbcTemplate.query(sql, new ResultSetExtractor<Map>() {
            @Override
            public Map extractData(ResultSet resultSet) throws SQLException, DataAccessException {

                while (resultSet.next()) {
                    mapOfPetTypes.put(resultSet.getInt("pet_type_id"), new PetType(
                            resultSet.getString("pet_type"),
                            resultSet.getInt("pet_type_id")
                    ));
                }
                return mapOfPetTypes;
            }
        });
    }

}