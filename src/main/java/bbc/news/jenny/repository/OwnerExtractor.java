package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Owner;
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
public class OwnerExtractor {


    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Map extract() {
        String sql = "SELECT * FROM owners ORDER BY owner_id ASC;";

        HashMap<Integer, Owner> mapOfOwners = new HashMap<Integer, Owner>();

        return namedParameterJdbcTemplate.query(sql, new ResultSetExtractor<Map>() {
            @Override
            public Map extractData(ResultSet resultSet) throws SQLException, DataAccessException {

                while (resultSet.next()) {
                    mapOfOwners.put(resultSet.getInt("owner_id"), new Owner(
                            resultSet.getInt("owner_id"),
                            resultSet.getString("owner_name"),
                            resultSet.getInt("owner_age"))
                    );
                }
                return mapOfOwners;
            }
        });
    }

}
