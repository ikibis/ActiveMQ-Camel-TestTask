package ru.kibis.activemq.task1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        MessageSender sender = context.getBean(MessageSender.class);
        int count = 0;
        while (count < 100) {
            if (count % 10 == 0) {
                sender.send("");
            } else {
                sender.send("Hello!" + new Random().nextInt());
            }
            count++;
        }
    }
}