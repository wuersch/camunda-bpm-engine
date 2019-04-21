package ch.helsana.bpm.config;

import java.util.Arrays;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

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
    private String db;

    @Value("${ods.mongodb.username}")
    private String username;

    @Value("${ods.mongodb.password}")
    private String password;

    @Bean
    MongoClient mongoClient() {
        MongoCredential credential = MongoCredential.createCredential(username, db, password.toCharArray());
        
        MongoClient mongoClient = MongoClients.create(
            MongoClientSettings.builder()
                               .applyToClusterSettings(builder -> 
                                    builder.hosts(Arrays.asList(new ServerAddress("host1", 27017)))
                                )
                               .credential(credential)
                               .build());  
        
        return mongoClient;  
    }
}