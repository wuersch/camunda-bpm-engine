package ch.helsana.bpm.integration;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.springframework.stereotype.Component;

@Component
public class ExampleRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        onException(Exception.class)
            .to("log:ch.helsana.bpm.integration.ExampleRoute?level=ERROR");

        from("direct:example")
            .routeId("ExampleRoute")
            .bean("GetBankRequestBuilder")
            .setHeader(CxfConstants.OPERATION_NAME, constant("Add"))
            .to("cxf://http://www.thomas-bayer.com/axis2/services/BLZService?serviceClass=com.thomas_bayer.blz.BLZServicePortType&wsdlURL=/wsdl/getBank.wsdl")
            //.to("mongodb:mongoClient?database=camunda&collection=partners&operation=insert")
            .log("The response was ${body[0]}");
            ;
    }
}