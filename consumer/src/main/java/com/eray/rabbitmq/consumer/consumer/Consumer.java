package com.eray.rabbitmq.consumer.consumer;

import com.eray.rabbitmq.consumer.domain.Student;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @RabbitListener(queues="${eray.rabbitmq.queue}", containerFactory="erayFactory")
    public void recievedMessage(Student student) {
        System.out.println("Recieved Message: " + student.toString());
    }
}
