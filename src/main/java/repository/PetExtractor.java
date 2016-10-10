package repository;

import bbc.news.jenny.domain.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by roberj78 on 06/10/2016.
 */
public class PetExtractor {

    public List<Pet> petList = new ArrayList<Pet>();


    public List<Pet> extract() {

        DBQuery dbQuery = new DBQuery();

        ResultSet resultSet = dbQuery.sendSelectQuery("SELECT * FROM pets ORDER BY pet_id ASC;");


        try {
            while (resultSet.next()) {

                int petId = resultSet.getInt("pet_id");
                int ownerId = resultSet.getInt("owner_id");
                String petName = resultSet.getString("pet_name");
                int petAge = resultSet.getInt("pet_age");
                int petHunger = resultSet.getInt("pet_hunger");
                int petTypeId = resultSet.getInt("pet_type_id");


                switch (petTypeId) {
                    case 1://guineapig
                        petList.add(new GuineaPig(petId, ownerId, petName, petAge, petHunger, petTypeId));
                        break;
                    case 2://cat
                        petList.add(new Cat(petId, ownerId, petName, petAge, petHunger, petTypeId, 100));
                        break;
                    case 3://pig
                        petList.add(new Pig(petId, ownerId, petName, petAge, petHunger, petTypeId));
                        break;
                    case 4://dog
                        petList.add(new Dog(petId, ownerId, petName, petAge, petHunger, petTypeId, true));
                        break;
                }


            }

        } catch (SQLException e) {
            //JDBCTutorialUtilities.printSQLException(e);
        }

//        for (
//                Pet pet : petList) {
//            System.out.println(pet.toString());
//        }
//        System.out.println("\n");

        return petList;
    }

}
