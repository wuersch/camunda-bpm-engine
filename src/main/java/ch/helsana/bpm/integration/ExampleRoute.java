package ch.helsana.bpm.integration;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.model.dataformat.JsonLibrary;
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
            .setHeader(CxfConstants.OPERATION_NAME, constant("getBank"))
            .enrich("cxf://http://www.thomas-bayer.com/axis2/services/BLZService?serviceClass=com.thomas_bayer.blz.BLZServicePortType&wsdlURL=/wsdl/BLZService.wsdl")
            .log("The SOAP response from getBank was ${body}")
            .marshal().json(JsonLibrary.Gson)
            .log("The JSON response from getBank was ${body}")
            .to("mongodb:mongoClient?database=camunda&collection=partners&operation=insert")
        ;
    }
}