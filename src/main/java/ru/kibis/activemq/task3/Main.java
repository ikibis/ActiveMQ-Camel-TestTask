package ru.kibis.activemq.task3;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    private static final Logger LOGGER = LogManager.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new MavenRouteBuilder());
        camelContext.start();
        URL page = new URL("http://localhost:8080/stat");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(page.openStream()));
        String inputLine;
        while ((inputLine = in.readLine()) != null) {
            LOGGER.info(inputLine);
        }
        in.close();
        Thread.sleep(10000);
        camelContext.stop();
    }
}
