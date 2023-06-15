package com.redhat.examples.camel;

import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class DownloadRoute extends RouteBuilder {

    @Override
    public void configure() {
        from("ftp://ftpuser@localhost:21/downloads?password=ftppass&passiveMode=true&delete=true")
                .log(LoggingLevel.INFO, "downloading file ${file:name}")
                .to("file:///Users/jeremyrdavis/Desktop/downloads/?fileName=copy-of-${file:name}");

    }
}
