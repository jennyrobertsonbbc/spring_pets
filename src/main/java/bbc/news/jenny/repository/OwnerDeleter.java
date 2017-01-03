package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Controller;


@Controller
public class OwnerDeleter {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void delete(Owner owner) {

        String sql = "DELETE FROM owners WHERE owner_id = :ownerId;";

        MapSqlParameterSource parameters = new MapSqlParameterSource();

        parameters.addValue("ownerId", owner.getOwnerId());

        int numberDeleted = namedParameterJdbcTemplate.update(sql, parameters);

        System.out.println("Owners deleted = " + numberDeleted);
    }

}
