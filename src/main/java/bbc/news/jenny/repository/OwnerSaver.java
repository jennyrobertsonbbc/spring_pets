package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Owner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

@Repository
public class OwnerSaver {

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public int save(Owner owner) {

        if (owner.getOwnerId() == null) {

            KeyHolder keyHolder = new GeneratedKeyHolder();

            String sql = "";
            MapSqlParameterSource parameters = new MapSqlParameterSource();

            sql = "INSERT into owners " +
                    "(owner_id, owner_name ,owner_age,owner_health ,owner_type_id) " +
                    "VALUES(:owner_id,:owner_name,:owner_age,:owner_health,:owner_type_id);";

            parameters.addValue("owner_id", owner.getOwnerId());
            parameters.addValue("owner_name", owner.getName());
            parameters.addValue("owner_age", owner.getAge());

            namedParameterJdbcTemplate.update(sql, parameters, keyHolder);
            int newKey = (int) keyHolder.getKeys().get("owner_id");
            return newKey;
        } else {

            String sql = "";
            MapSqlParameterSource parameters = new MapSqlParameterSource();


            sql = "UPDATE owners SET " +
                    "owner_id = :owner_id," +
                    "owner_name = :owner_name," +
                    "owner_age = :owner_age," +
                    "owner_health = :owner_health," +
                    "owner_type_id  = :owner_type_id" +
                    " WHERE owner_id = :owner_id;";


            parameters.addValue("owner_id", owner.getOwnerId());
            parameters.addValue("owner_name", owner.getName());
            parameters.addValue("owner_age", owner.getAge());
            parameters.addValue("owner_id", owner.getOwnerId());

            namedParameterJdbcTemplate.update(sql, parameters);
            return 0;
        }
    }


}
