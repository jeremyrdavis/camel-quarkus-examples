package com.redhat.examples.camel;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.timer;

@ApplicationScoped
public class UploadRoute extends RouteBuilder {


    @Override
    public void configure() {

        from("file:///Users/jeremyrdavis/Desktop/uploads")
                .log(LoggingLevel.INFO, "processing file ${file:name}")
                .to("ftp://ftpuser@localhost:21/uploads?password=ftppass&passiveMode=true");
    }

}
