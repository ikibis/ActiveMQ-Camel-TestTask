package ru.kibis.activemq.task2;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("ru.kibis.activemq.task2")
public class Config {

    private ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();

    @Bean
    public ActiveMQConnectionFactory connectionFactory() {
        return connectionFactory;
    }
}
