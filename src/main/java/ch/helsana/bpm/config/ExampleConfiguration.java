package ch.helsana.bpm.config;

import com.mongodb.Mongo;
import com.mongodb.MongoURI;

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
    Mongo mongoClient() {
        MongoURI mongoURI = new MongoURI("mongodb://" + mongoDbUsername + ":" + mongoDbPassword + "@" + mongoDbHost + ":" +mongoDbPort + "/" + mongoDb);
         /*
        MongoCredential credential = MongoCredential.createCredential(username, db, password.toCharArray());
       
        MongoClient mongoClient = MongoClients.create(
            MongoClientSettings.builder()
                               .applyToClusterSettings(builder -> 
                                    builder.hosts(Arrays.asList(new ServerAddress(mongoDbHost, mongoDbPort)))
                                )
                               .credential(credential)
                               .build());  
        */
        return new Mongo(mongoURI);  
    }
}