/*
package ru.kibis.activemq.task4;

import org.apache.camel.builder.RouteBuilder;
import ru.kibis.activemq.task2.EmptyMessageException;
import ru.kibis.activemq.task2.MessageChecker;

public class QueueCleaner extends RouteBuilder {

    String name = "consumer-queue-2";

    @Override
    public void configure() throws Exception {
        for (int i = 1; i < 3; i++) {
            from("activemq:queue:consumer-queue-" + i)
                    .to("mock:result");
        }
    }
}
*/
