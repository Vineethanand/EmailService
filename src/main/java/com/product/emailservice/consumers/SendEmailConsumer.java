package com.product.emailservice.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.emailservice.dtos.SendEmailDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class SendEmailConsumer {
    private ObjectMapper objectMapper;

    public SendEmailConsumer(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "sendEmail1", groupId = "71907")
    public void consumeEmail(String message) throws JsonProcessingException {
        SendEmailDto sendEmailDto = objectMapper.readValue(message, SendEmailDto.class);
        System.out.println("email" + sendEmailDto.getEmail());
        System.out.println("message" + sendEmailDto.getMessage());
    }
}
