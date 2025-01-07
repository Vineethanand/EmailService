package com.product.emailservice.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.product.emailservice.dtos.SendEmailDto;
import com.product.emailservice.producers.SendEmailProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/*
While setting up the Kafka using WSL in windows
There is a change is config required.
In server.properties in downloaded Kafka bundle (eg: /kafka_2.12-3.9.0)
Go to config/server.properties
Uncomment listeners=PLAINTEXT://:9092
Uncomment advertised.listeners= line and change it to advertised.listeners=PLAINTEXT://localhost:9092
Start the kafka server after it

Command to create a Kafka Topic
 ./kafka-topics.sh --create   \
 --bootstrap-server localhost:9092   \
 --replication-factor 1 --partitions 1   \
 --topic sendEmail1
 */

@RestController
@RequestMapping("/api/v1/email")
public class EmailController {

    private SendEmailProducer sendEmailProducer;

    public EmailController(SendEmailProducer sendEmailProducer) {
        this.sendEmailProducer = sendEmailProducer;
    }

    @PostMapping("/send")
    public String sendEmail(@RequestBody SendEmailDto sendEmailDto) throws JsonProcessingException {
        sendEmailProducer.sendEmail(sendEmailDto);
        return "Email sent successfully";
    }
}
