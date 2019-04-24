package ch.helsana.bpm.integration;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component("BsonValueBuilder")
public class BsonValueBuilder {
    public ObjectId build(String body) {
        return new ObjectId(body);
    }
}