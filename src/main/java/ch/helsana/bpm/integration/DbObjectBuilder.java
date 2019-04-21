package ch.helsana.bpm.integration;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component("DbObjectBuilder")
public class DbObjectBuilder {
    public void build(String body, Exchange exchange) {
        DBObject dbObject = (DBObject) BasicDBObject.parse(body);
        exchange.getOut().setBody(dbObject);
    }
}