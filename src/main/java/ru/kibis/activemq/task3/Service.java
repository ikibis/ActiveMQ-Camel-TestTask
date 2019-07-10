package ru.kibis.activemq.task3;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.maven.model.Model;
import org.apache.maven.model.io.xpp3.MavenXpp3Reader;
import org.codehaus.plexus.util.xml.pull.XmlPullParserException;
import org.springframework.context.annotation.Bean;

import java.io.*;

public class Service {
    private static final Logger LOGGER = LogManager.getLogger(Service.class.getName());
    private MavenXpp3Reader reader = new MavenXpp3Reader();

    @Bean
    public String stat() {
        String name = null;
        String version = null;
        try (FileReader fileReader = new FileReader("pom.xml")) {
            Model model = reader.read(fileReader);
            name = model.getArtifactId();
            version = model.getVersion();
        } catch (IOException | XmlPullParserException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return "ArtifactId : {" + name + "} Version : {" + version + "}";
    }
}