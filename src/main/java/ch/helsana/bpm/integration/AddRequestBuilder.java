package ch.helsana.bpm.integration;

import org.apache.camel.Exchange;

public class AddRequestBuilder {
    public void build(Exchange exchange) {
        exchange.getOut().setBody(new Object[] {1 , 2});
    }
}