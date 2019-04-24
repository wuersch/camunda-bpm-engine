package ch.helsana.bpm.integration;

import com.mongodb.BasicDBObject;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component("DbObjectUnmarshaller")
public class DbObjectUnmarshaller {
    public String build(BasicDBObject response) {
        ObjectId objectId = response.getObjectId("_id");
        return objectId.toHexString();
    }
}