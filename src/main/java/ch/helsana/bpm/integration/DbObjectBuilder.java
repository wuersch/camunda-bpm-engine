package ch.helsana.bpm.integration;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import org.springframework.stereotype.Component;

@Component("DbObjectBuilder")
public class DbObjectBuilder {
    public DBObject build(String body) {
        String json = body.replace("[", "").replace("]", "");
        return (DBObject) BasicDBObject.parse(json);
    }
}