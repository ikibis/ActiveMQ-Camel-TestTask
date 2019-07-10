package ru.kibis.activemq.task1;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertEquals;

import javax.jms.*;

public class SimpleMessageListenerTest {
    ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    MessageSender sender = context.getBean(MessageSender.class);
    ActiveMQConnectionFactory activeMQConnectionFactory = context.getBean(ActiveMQConnectionFactory.class);
    ActiveMQDestination destination = context.getBean(ActiveMQDestination.class);
    ActiveMQDestination[] matchingDestinations = destination.getCompositeDestinations();

    /*@Test
    public void whenSendMessageThenMessageGetsInTwoConsumersQueues() throws JMSException {
        sender.send("Hello!");
        QueueConnection connection = activeMQConnectionFactory.createQueueConnection();
        QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);

        ActiveMQQueue firstQueue = (ActiveMQQueue) matchingDestinations[0];
        MessageConsumer firstConsumer = session.createConsumer(firstQueue);
        connection.start();
        Message firstMessage = firstConsumer.receive();
        assertEquals(((TextMessage) firstMessage).getText(), "Hello!");

        ActiveMQQueue secondQueue = (ActiveMQQueue) matchingDestinations[1];
        MessageConsumer secondConsumer = session.createConsumer(secondQueue);
        Message secondMessage = secondConsumer.receive();
        assertEquals(((TextMessage) secondMessage).getText(), "Hello!");

        connection.close();
    }*/
}


