package ch.helsana.bpm.integration;

import org.apache.camel.ResolveEndpointFailedException;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class ExampleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        onException(ResolveEndpointFailedException.class)
            .to("log:ch.helsana.bpm.integration.ExampleRoute?level=ERROR");

        from("direct:example")
            .routeId("ExampleRoute")
            .enrich("cxf:bean:GetPartnerRequestBuilder://http://localhost:8088/mock?serviceClass=com.example.camunda.service.PartnerService&wsdlURL=/wsdl/PartnerService.wsdl") // no aggregation strategy, use body of response by default
            .to("mongodb:mongoClient?database=camunda&collection=partners&operation=insert");
    }
}