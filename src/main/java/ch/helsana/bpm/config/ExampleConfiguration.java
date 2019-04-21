package ch.helsana.bpm.config;

import java.util.Arrays;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleConfiguration {
    @Value("${ods.mongodb.host}")
    private String mongoDbHost;

    @Value("${ods.mongodb.port}")
    private int mongoDbPort;

    @Value("${ods.mongodb.db}")
    private String mongoDb;

    @Value("${ods.mongodb.username}")
    private String mongoDbUsername;

    @Value("${ods.mongodb.password}")
    private String mongoDbPassword;

    @Bean
    MongoClient mongoClient() {
        MongoCredential credential = MongoCredential.createCredential(mongoDbUsername, mongoDb, mongoDbPassword.toCharArray());
        MongoClient mongoClient = new MongoClient(new ServerAddress("host1", 27017),
                                                  Arrays.asList(credential));
        return mongoClient;
    }
}