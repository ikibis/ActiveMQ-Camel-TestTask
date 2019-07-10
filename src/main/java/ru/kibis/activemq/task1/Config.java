package ru.kibis.activemq.task1;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;

import static org.apache.activemq.ActiveMQConnectionFactory.DEFAULT_BROKER_URL;

@Configuration
@ComponentScan("ru.kibis.activemq.task1")
public class Config {

    private ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

    private static final String QUEUE = "producer-queue";
    private ActiveMQDestination destination = new ActiveMQQueue("consumer-queue-1, consumer-queue-2");

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        connectionFactory.setBrokerURL(DEFAULT_BROKER_URL);
        return connectionFactory;
    }

    @Bean
    public ActiveMQDestination getDestination() {
        return this.destination;
    }

    @Bean
    public MessageListenerContainer listenerContainer(SimpleMessageListener messageListener) {
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setDestinationName(QUEUE);
        container.setMessageListener(messageListener);
        return container;
    }

    @Bean
    public JmsTemplate jmsTemplate() {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory());
        jmsTemplate.setDefaultDestinationName(QUEUE);
        return jmsTemplate;
    }
}