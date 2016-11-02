package bbc.news.jenny.repository;

import bbc.news.jenny.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class PetExtractor {

    @Autowired
    private DBQuery dbQuery;

    public List<Pet> extract() {
        List<Pet> petList = new ArrayList<Pet>();//todo does this need to be a bean?
        ResultSet resultSet = dbQuery.sendSelectQuery("SELECT * FROM pets ORDER BY pet_id ASC;");

        try {
            while (resultSet.next()) {

                Integer petId = resultSet.getInt("pet_id");
                Integer ownerId = resultSet.getInt("owner_id");
                String petName = resultSet.getString("pet_name");
                Integer petAge = resultSet.getInt("pet_age");
                Integer petHealth = resultSet.getInt("pet_health");
                Integer petTypeId = resultSet.getInt("pet_type_id");


                switch (petTypeId) {
                    case 1://guineapig
                        petList.add(new GuineaPig(petId, ownerId, petName, petAge, petHealth, petTypeId));
                        break;
                    case 2://cat
                        petList.add(new Cat(petId, ownerId, petName, petAge, petHealth, petTypeId, 100));
                        break;
                    case 3://pig
                        petList.add(new Pig(petId, ownerId, petName, petAge, petHealth, petTypeId));
                        break;
                    case 4://dog
                        petList.add(new Dog(petId, ownerId, petName, petAge, petHealth, petTypeId, true));
                        break;
                }


            }

        } catch (SQLException e) {
            //JDBCTutorialUtilities.printSQLException(e);
        }


        return petList;
    }

}
