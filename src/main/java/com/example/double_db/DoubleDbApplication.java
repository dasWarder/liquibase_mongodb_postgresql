package com.example.double_db;

import com.example.double_db.repository.IssueRepository;
import com.example.double_db.repository.PersonRepository;
import liquibase.Liquibase;
import liquibase.database.DatabaseFactory;
import liquibase.exception.LiquibaseException;
import liquibase.ext.mongodb.database.MongoLiquibaseDatabase;
import liquibase.resource.ClassLoaderResourceAccessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = { IssueRepository.class })
@EnableJpaRepositories(basePackageClasses = { PersonRepository.class })
public class DoubleDbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoubleDbApplication.class, args);
    }

}
