package ch.helsana.bpm.integration;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExampleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:example")
         .to("log:ch.helsana.bpm?level=INFO");
    }
}