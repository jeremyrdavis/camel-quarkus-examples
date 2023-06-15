package com.redhat.examples.camel;


import jakarta.enterprise.context.ApplicationScoped;
import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class SplitRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("ftp://ftpuser@localhost:21/multi?password=ftppass&passiveMode=true&delete=true")
            .split(body().convertToString().tokenize("\n"))
            .to("file:///Users/jeremyrdavis/Desktop/downloads/?fileName=${file:name}-${header.CamelSplitIndex}.txt");
    }
}
