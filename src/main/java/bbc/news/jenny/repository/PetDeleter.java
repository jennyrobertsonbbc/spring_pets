package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class PetDeleter {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void delete(Pet pet) {

        String sql = "DELETE FROM pets WHERE pet_id = :petId;";

        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("petId", pet.getPetId());

        int numberDeleted = namedParameterJdbcTemplate.update(sql, parameters);

        System.out.println("Pets deleted = " + numberDeleted);
    }

}
