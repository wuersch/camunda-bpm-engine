package ch.helsana.bpm.integration;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ExampleRoute extends RouteBuilder {
    private final Logger LOGGER = LoggerFactory.getLogger(ExampleRoute.class);

    @Override
    public void configure() throws Exception {
        onException(Exception.class)
            .to("log:ch.helsana.bpm.integration.ExampleRoute?level=ERROR");

        from("direct:example")
            .routeId("ExampleRoute")
            .setHeader(CxfConstants.OPERATION_NAME, constant("getBank"))
            //.enrich("cxf://http://www.thomas-bayer.com/axis2/services/BLZService?serviceClass=com.thomas_bayer.blz.BLZServicePortType&wsdlURL=/wsdl/BLZService.wsdl")
            .enrich("cxf://http://192.168.1.174:8088/mockBLZServiceSOAP11Binding?serviceClass=com.thomas_bayer.blz.BLZServicePortType&wsdlURL=/wsdl/BLZService.wsdl")
            .marshal().json(JsonLibrary.Gson)
            .bean("DbObjectBuilder")
            .to("mongodb:mongoClient?database=camunda&collection=blzdetails&operation=insert")
            .log("The mongodb response from insert was ${body}")
            .bean("DbObjectUnmarshaller")
        ;

        from("direct:anotherExample")
            .routeId("AnotherExampleRoute")
            .log("The body is ${body}")
            .bean("BsonValueBuilder")
            .to("mongodb:mongoClient?database=camunda&collection=blzdetails&operation=findById")
        ;
    }
}