package ru.kibis.activemq.task2;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class SimpleRouteBuilder extends RouteBuilder {
    public void configure() {
        from("activemq:queue:producer")
                .doTry()
                .process(new MessageChecker())
                .unmarshal().base64()
                .to("activemq:queue:consumer")
                .doCatch(EmptyMessageException.class)
                .transform().simple("${exception.message}")
                .to("stream:out")
                .end();
    }
}
