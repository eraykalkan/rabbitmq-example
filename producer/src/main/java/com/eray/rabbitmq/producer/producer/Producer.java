package com.eray.rabbitmq.producer.producer;

import com.eray.rabbitmq.producer.domain.Student;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Value("${eray.rabbitmq.exchange}")
    private String exchange;

    public void produce(Student student){
        String routingKey = student.getRoutingKey();
        amqpTemplate.convertAndSend(exchange, routingKey, student);
        System.out.println("Send msg = " + student);
    }

}
