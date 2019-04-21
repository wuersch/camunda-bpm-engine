package ch.helsana.bpm.integration;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component("DbObjectBuilder")
public class DbObjectBuilder {
    public void build(String body, Exchange exchange) {
        String json = body.replace("[", "").replace("]", "");
        DBObject dbObject = (DBObject) BasicDBObject.parse(json);
        exchange.getOut().setBody(dbObject);
    }
}