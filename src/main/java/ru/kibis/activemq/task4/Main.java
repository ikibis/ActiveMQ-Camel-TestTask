/*
package ru.kibis.activemq.task4;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.advisory.DestinationSource;
import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.apache.activemq.command.ActiveMQDestination;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.camel.CamelContext;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;
import org.restlet.Client;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.kibis.activemq.task3.MavenRouteBuilder;

import javax.jms.QueueConnection;
import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws Exception {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ActiveMQConnectionFactory activeMQConnectionFactory = context.getBean(ActiveMQConnectionFactory.class);
        JmsComponent jms = JmsComponent.jmsComponent(activeMQConnectionFactory);
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addComponent("activemq", jms);
        camelContext.addRoutes(new QueueCleaner());

          camelContext.start();
        Thread.sleep(1000);
         camelContext.stop();

       // String url = "service:jmx:rmi:///jndi/rmi://localhost:8161/jmxrmi";
        JMXServiceURL url = new JMXServiceURL("service:jmx:rmi:///jndi/rmi://<server>:<port>/jmxrmi");
        JMXConnector connector = JMXConnectorFactory.connect(url);
        connector.connect();
        MBeanServerConnection mbsc = connector.getMBeanServerConnection();

        ObjectName objectName = new ObjectName("org.apache.activemq:brokerName=localhost,type=Broker");
        BrokerViewMBean mBean = MBeanServerInvocationHandler.newProxyInstance(mbsc, objectName, BrokerViewMBean.class, true);

        for (ObjectName queueName : mBean.getQueues()) {
            QueueViewMBean queueMBean = MBeanServerInvocationHandler.newProxyInstance(mbsc, queueName, QueueViewMBean.class, true);

            // queue name
            System.out.println("Queue Name:" + queueMBean.getName());

            // consumer count
            System.out.println("Number of Consumers:" + queueMBean.getConsumerCount());
       // }

    }
}

*/
/*

    }

  //  ActiveMQConnection conn = ActiveMQConnection.makeConnection("http://localhost:8161");
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        ActiveMQConnection activeMQConnection = (ActiveMQConnection) connectionFactory.createConnection();
        ActiveMQDestination destination = new ActiveMQQueue("consumer-queue-2, producer-queue");
        ActiveMQDestination[] activeMQDestinations = destination.getCompositeDestinations();*//*

        //    activeMQConnection.start();
      */
/*  Set<ActiveMQQueue> allque = conn.getDestinationSource().getQueues();
        for (ActiveMQQueue queue: allque) {
            System.out.println(queue.getQueueName());
        }
*//*


       */
/* for (int i = 0; i < activeMQDestinations.length; i++) {
            activeMQConnection.destroyDestination(activeMQDestinations[i]);
        }*//*

        //  connection.stop();*/
