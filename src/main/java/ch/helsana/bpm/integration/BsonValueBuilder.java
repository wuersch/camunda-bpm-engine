package ch.helsana.bpm.integration;

import org.bson.BsonString;
import org.bson.BsonValue;
import org.springframework.stereotype.Component;

@Component("BsonValueBuilder")
public class BsonValueBuilder {
    public BsonValue build(String body) {
        return new BsonString(body);
    }
}