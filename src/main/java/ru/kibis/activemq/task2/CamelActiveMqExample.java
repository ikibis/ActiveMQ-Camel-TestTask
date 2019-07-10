package ru.kibis.activemq.task2;

import org.apache.activemq.ActiveMQConnectionFactory;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Base64;

public class CamelActiveMqExample {
    public static final void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ActiveMQConnectionFactory activeMQConnectionFactory = context.getBean(ActiveMQConnectionFactory.class);
        JmsComponent jms = JmsComponent.jmsComponent(activeMQConnectionFactory);
        camelContext.addComponent("activemq", jms);
        try {
            camelContext.addRoutes(new SimpleRouteBuilder());
            ProducerTemplate template = camelContext.createProducerTemplate();
            camelContext.start();
            for (int i = 0; i < 50; i++) {
                if (i % 10 == 0) {
                    template.sendBody("activemq:queue:producer", "");
                } else {
                    template.sendBody("activemq:queue:producer", Base64.getEncoder().encode(("body" + i).getBytes()));
                }
            }
        } finally {
            camelContext.stop();
        }
    }
}

