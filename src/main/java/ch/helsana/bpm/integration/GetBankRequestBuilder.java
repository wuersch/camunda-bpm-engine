package ch.helsana.bpm.integration;

import org.apache.camel.Exchange;
import org.springframework.stereotype.Component;

@Component("GetBankRequestBuilder")
public class GetBankRequestBuilder {
    public void build(String blz, Exchange exchange) {
        exchange.getOut().setBody(blz);
    }
}