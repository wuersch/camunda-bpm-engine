package ch.helsana.bpm.integration;

import com.mongodb.BasicDBObject;

import org.apache.camel.Exchange;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

@Component("DbObjectUnmarshaller")
public class DbObjectUnmarshaller {
    public void build(BasicDBObject response, Exchange exchange) {
        ObjectId objectId = response.getObjectId("_id");
        exchange.getOut().setBody(objectId.toHexString());
    }
}