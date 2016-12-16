package bbc.news.jenny.repository;

import bbc.news.jenny.domain.PetType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class PetTypeDeleter {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void delete(PetType petType) {
//
//        String sql = "DELETE FROM pets WHERE pet_id = :petId;";
//
//        MapSqlParameterSource parameters = new MapSqlParameterSource();
//
//        parameters.addValue("petId", petType.getPetId());
//
//        int numberDeleted = namedParameterJdbcTemplate.update(sql, parameters);
//
//        System.out.println("Pets deleted = " + numberDeleted);
    }

}
