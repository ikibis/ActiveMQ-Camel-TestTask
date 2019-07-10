package ru.kibis.activemq.task3;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MavenRouteBuilder extends RouteBuilder {
    private static final Logger LOGGER = LogManager.getLogger(Service.class.getName());

    public void configure() {
        try {
            restConfiguration()
                    .component("restlet")
                    .host("localhost").port("8080")
                    .bindingMode(RestBindingMode.auto);

            rest().get("/stat").produces("text/plain").route().bean(Service.class, "stat").endRest();

        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }

    }


}
