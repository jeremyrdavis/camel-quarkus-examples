package com.redhat.examples.camel;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class KafkaRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {

        from("kafka:hellos")
                .routeId("FromKafka2FTP")
                .log(LoggingLevel.INFO, "Received : \"${body}\"")
                .to("ftp://ftpuser@localhost:21/kafka?password=ftppass&passiveMode=true");

    }
}
