package bbc.news.jenny.repository;

import bbc.news.jenny.domain.PetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Controller
public class PetTypeExtractor {


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public List<PetType> extract() {
        String sql = "SELECT * FROM pet_types;";

        return namedParameterJdbcTemplate.query(sql, new PetTypeRowMapper());
    }

    public class PetTypeRowMapper implements RowMapper<PetType> {


        @Override
        public PetType mapRow(ResultSet resultSet, int rowNum) throws SQLException {

            String name = resultSet.getString("pet_type");
            int id = resultSet.getInt("pet_type_id");

            return new PetType(name, id);

        }
    }

}
