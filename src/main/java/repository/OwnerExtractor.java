package repository;

import bbc.news.jenny.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roberj78 on 06/10/2016.
 */
public class OwnerExtractor {

    public List<Owner> ownerList = new ArrayList<Owner>();


    public List<Owner> extract() {

        DBQuery dBQuery = new DBQuery();

        ResultSet resultSet = dBQuery.sendSelectQuery("SELECT * FROM owners ORDER BY owner_id ASC;");


        try {
            while (resultSet.next()) {

                int ownerId = resultSet.getInt("owner_id");
                String ownerName = resultSet.getString("owner_name");
                int ownerAge = resultSet.getInt("owner_age");

                ownerList.add(new Owner(ownerId,ownerName,ownerAge));

            }

        } catch (SQLException e) {
            //JDBCTutorialUtilities.printSQLException(e);
        }

//        for ( Owner owner : ownerList) {
//            System.out.println(owner.toString());
//        }
//        System.out.println("\n");

        return ownerList;
    }

}
