package bbc.news.jenny.repository;

import bbc.news.jenny.domain.PetsApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public PetRepository petRepository() {
        return new PetRepository();
    }

    @Bean
    public PetExtractor petExtractor() { return new PetExtractor(); }

    @Bean
    public PetSaver petSaver() { return new PetSaver(); }

    @Bean
    public PetDeleter petDeleter() {return  new PetDeleter(); }

    @Bean
    public DBQuery dbQuery() {return new DBQuery(); }

}
