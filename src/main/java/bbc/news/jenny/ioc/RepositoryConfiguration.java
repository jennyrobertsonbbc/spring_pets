package bbc.news.jenny.ioc;

import bbc.news.jenny.repository.*;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class RepositoryConfiguration {
    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost/";
    static final String EXISTING_DATABASE_NAME = "pets_db";

    //  Database credentials
    // Your database username and password
    static final String USER = "roberj78";
    static final String PASS = "roberj78";

    @Bean
    public PetRepository petRepository() {
        return new PetRepository();
    }
    @Bean
    public PetExtractor petExtractor() {
        return new PetExtractor();
    }
    @Bean
    public PetSaver petSaver() {
        return new PetSaver();
    }
    @Bean
    public PetDeleter petDeleter() {
        return new PetDeleter();
    }

    @Bean
    public PetTypeRepository petTypeRepository() {
        return new PetTypeRepository();
    }
    @Bean
    public PetTypeExtractor petTypeExtractor() {
        return new PetTypeExtractor();
    }
    @Bean
    public PetTypeSaver petTypeSaver() {
        return new PetTypeSaver();
    }
    @Bean
    public PetTypeDeleter petTypeDeleter() {
        return new PetTypeDeleter();
    }


    @Bean
    public DataSource dataSource() {
        BasicDataSource basicDataSource = new BasicDataSource();
        basicDataSource.setDriverClassName(JDBC_DRIVER);
        basicDataSource.setUrl(DB_URL + EXISTING_DATABASE_NAME);
        basicDataSource.setUsername(USER);
        basicDataSource.setPassword(PASS);

        return basicDataSource;
    }

    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(DataSource dataSource) {
        return new NamedParameterJdbcTemplate(dataSource);

    }


}
