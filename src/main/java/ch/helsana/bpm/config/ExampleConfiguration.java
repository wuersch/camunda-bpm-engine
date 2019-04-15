package ch.helsana.bpm.config;

import com.mongodb.MongoClient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleConfiguration {
    @Value("${ods.mongodb.host}")
    private String mongoDbHost;

    @Value("${ods.mongodb.port}")
    private int mongoDbPort;

    @Bean
    MongoClient mongoClient() {
        return new MongoClient(mongoDbHost, mongoDbPort);
    }
}