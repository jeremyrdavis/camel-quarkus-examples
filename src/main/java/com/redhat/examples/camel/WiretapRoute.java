package com.redhat.examples.camel;


import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class WiretapRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("ftp://ftpuser@localhost:21/wiretapdownloads?password=ftppass&passiveMode=true&delete=true")
                .wireTap("file:///Users/jeremyrdavis/Desktop/wiretap?fileName=copy-of-${file:name}")
                .log(LoggingLevel.INFO, "wiretapped file ${file:name}")
                .to("file:///Users/jeremyrdavis/Desktop/downloads/?fileName=copy-of-${file:name}");
    }
}
