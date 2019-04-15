package ch.helsana.bpm.integration;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExampleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        onException(Exception.class)
            .to("log:ch.helsana.bpm.integration.ExampleRoute?level=ERROR");

        from("direct:example")
            .routeId("ExampleRoute")
            .enrich("cxf:todo") // no aggregation strategy, use body of response by default
            .to("mongodb:mongoClient?database=camunda&collection=partners&operation=insert");
    }
}