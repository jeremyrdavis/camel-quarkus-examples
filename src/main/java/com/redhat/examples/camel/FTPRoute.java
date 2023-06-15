package com.redhat.examples.camel;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

import static org.apache.camel.builder.endpoint.StaticEndpointBuilders.timer;

@ApplicationScoped
public class FTPRoute extends RouteBuilder {


    @Override
    public void configure() {

        from("file:///Users/jeremyrdavis/Desktop/downloads")
                .log(LoggingLevel.INFO, "processing file ${file:name}")
//                .to("file:///Users/jeremyrdavis/Desktop/uploads")
                .to("ftp://ftpuser@localhost:21/uploads?password=ftppass&passiveMode=true");
//        from("ftp://ftpuser@localhost:21/uploads?password=ftppass")
//                .log(LoggingLevel.INFO, "processing file ${file:name}")
////                .split(body().convertToString().tokenize("\n"))
//                .setHeader(Exchange.FILE_NAME, body())
//                .to("file://Users/jeremyrdavis/Desktop/downloads/?fileName=copy-of-${file:name}");
    }
}
