package ch.helsana.bpm.integration;

import com.mongodb.BasicDBObject;

import org.springframework.stereotype.Component;

@Component("DbObjectUnmarshaller2")
public class DbObjectUnmarshaller2 {
    public String build(BasicDBObject response) {
        Object bez = response.get("bezeichnung");
        return bez.toString();
    }
}