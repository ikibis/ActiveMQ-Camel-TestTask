package ru.kibis.activemq.task1;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.jms.*;

@Service
public class SimpleMessageListener implements MessageListener {
    private static final Logger LOGGER = LogManager.getLogger(SimpleMessageListener.class.getName());

    private final ActiveMQConnectionFactory connectionFactory;
    private final Destination destination;

    public SimpleMessageListener(ActiveMQConnectionFactory connectionFactory, Destination destination) {
        this.connectionFactory = connectionFactory;
        this.destination = destination;
    }

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try {
            String body = textMessage.getText();
            if (body.length() == 0) {
                throw new EmptyMessageException("-------Empty Message");
            } else {
                QueueConnection connection = connectionFactory.createQueueConnection();
                QueueSession session = connection.createQueueSession(false, QueueSession.AUTO_ACKNOWLEDGE);
                MessageProducer producer = session.createProducer(destination);
                producer.send(destination, message);
                session.close();
                connection.close();
                LOGGER.info(textMessage.getText());
            }
        } catch (EmptyMessageException | JMSException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}