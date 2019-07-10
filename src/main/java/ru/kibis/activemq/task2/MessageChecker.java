package ru.kibis.activemq.task2;

import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;

public class MessageChecker implements Processor {
    public void process(Exchange exchange) throws Exception {
        Message msg = exchange.getIn();
        String txt = msg.getBody(String.class);
        if (txt == null || txt.equals("")) {
            throw new EmptyMessageException("-------Empty Message");
        }
    }
}