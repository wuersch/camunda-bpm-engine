package ch.helsana.bpm.integration;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component("DbObjectBuilder")
public class DbObjectBuilder {
    private final Logger LOGGER = LoggerFactory.getLogger(DbObjectBuilder.class.getName());

    public void build(String body, Exchange exchange) {
        LOGGER.info("Body before: " + body);
        String json = body.replace("[", "\"BlzDetail\": {").replace(']', '}');
        LOGGER.info("Body after: " + body);
        DBObject dbObject = (DBObject) BasicDBObject.parse(json);
        exchange.getOut().setBody(dbObject);
    }
}