package ch.helsana.bpm.integration;

import org.apache.camel.ResolveEndpointFailedException;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.stereotype.Component;

@Component
public class ExampleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        onException(ResolveEndpointFailedException.class)
            .to("log:ch.helsana.bpm.integration.ExampleRoute?level=ERROR");

        from("direct:example")
            .routeId("ExampleRoute")
            //.bean("GetPartnerRequestBuilder")
            .setHeader(CxfConstants.OPERATION_NAME, constant("getPartner"))
            .to("cxf://http://localhost:8088/mock?serviceClass=com.example.camunda.service.PartnerServicePortType&wsdlURL=/wsdl/PartnerService.wsdl")
            //.to("mongodb:mongoClient?database=camunda&collection=partners&operation=insert")
            ;
    }
}