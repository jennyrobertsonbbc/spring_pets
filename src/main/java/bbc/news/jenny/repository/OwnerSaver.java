package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Owner;

import java.util.List;

/**
 * Created by roberj78 on 07/10/2016.
 */
public class OwnerSaver {
    public void save(List<Owner> listOfOwners){

        DBQuery dbQuery = new DBQuery();

        for(Owner owner : listOfOwners){

            String query = String.format("UPDATE owners SET " +
                            "owner_name = '%s'," +
                            "owner_age = '%d'" +
                            " WHERE owner_id = '%d';",
                    owner.getName(), owner.getAge(), owner.getOwnerID()
            );
            //System.out.println(query);

           dbQuery.sendUpdateQuery(query);



        }
        System.out.println("List of owners saved to DB");
    }

}
