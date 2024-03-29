package com.naipes.camelbasicexample.route;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class SimpleCamelRoute extends RouteBuilder {

    @Autowired
    Environment environment;

    @Override
    public void configure() throws Exception {
        from("{{startRoute}}")
            .log("Timer invoked and the body is: ${body}. " + environment.getProperty("message"))
            .pollEnrich("{{fromRoute}}")
            .to("{{toRoute}}");
    }
}
