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
            .bean("AddRequestBuilder")
            .setHeader(CxfConstants.OPERATION_NAME, constant("Add"))
            .to("cxf://http://www.dneonline.com/calculator.asmx?serviceClass=org.tempuri.CalculatorSoap&wsdlURL=/wsdl/Calculator.wsdl")
            //.to("mongodb:mongoClient?database=camunda&collection=partners&operation=insert")
            ;
    }
}