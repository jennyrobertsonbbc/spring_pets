package bbc.news.jenny.repository;

import bbc.news.jenny.domain.Pet;
import bbc.news.jenny.domain.PetType;
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
public class PetExtractor {

    @Autowired
    private PetTypeRepository petTypeRepository;
    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Map extract() {
        String sql = "SELECT * FROM pets ORDER BY pet_id ASC;";

        HashMap<Integer, Pet> mapOfPets = new HashMap<Integer, Pet>();

        PetType testPetType = new PetType("testType", 1000);
        Pet testPet = new Pet(3,"bobob",5,50,testPetType);


        return namedParameterJdbcTemplate.query(sql, new ResultSetExtractor<Map>(){
            @Override
            public Map extractData(ResultSet resultSet) throws SQLException,DataAccessException {



                HashMap<Integer,Pet> mapRet= new HashMap<Integer,Pet>();


                while(resultSet.next()){
                    mapRet.put(resultSet.getInt("pet_id"),new Pet(3,resultSet.getString("pet_name"),5,50,testPetType));
                }
                return mapRet;
            }
        });
    }

    //    public class PetRowMapper implements RowMapper<Pet> {
//
//
//        @Override
//        public Pet mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//
//            Integer petId = resultSet.getInt("pet_id");
//            Integer ownerId = resultSet.getInt("owner_id");
//            String petName = resultSet.getString("pet_name");
//            Integer petAge = resultSet.getInt("pet_age");
//            Integer petHealth = resultSet.getInt("pet_health");
//            Integer petTypeId = resultSet.getInt("pet_type_id");
//
//            List<PetType> listOfPetTypes = petTypeRepository.load();
//            PetType petType = null;
//
//            for (PetType petTypeSearch : listOfPetTypes) {
//                if (petTypeSearch.getId() == petTypeId) {
//                    petType = petTypeSearch;
//                }
//            }
//            return new Pet(petId, ownerId, petName, petAge, petHealth, petType);
//        }
//    }


//    public class PetRowMapper implements RowMapper<Pet> {
//
//
//        @Override
//        public Pet mapRow(ResultSet resultSet, int rowNum) throws SQLException {
//
//            Integer petId = resultSet.getInt("pet_id");
//            Integer ownerId = resultSet.getInt("owner_id");
//            String petName = resultSet.getString("pet_name");
//            Integer petAge = resultSet.getInt("pet_age");
//            Integer petHealth = resultSet.getInt("pet_health");
//            Integer petTypeId = resultSet.getInt("pet_type_id");
//
//            List<PetType> listOfPetTypes = petTypeRepository.load();
//            PetType petType = null;
//
//            for (PetType petTypeSearch : listOfPetTypes) {
//                if (petTypeSearch.getId() == petTypeId) {
//                    petType = petTypeSearch;
//                }
//            }
//            return new Pet(petId, ownerId, petName, petAge, petHealth, petType);
//        }
//    }

}
