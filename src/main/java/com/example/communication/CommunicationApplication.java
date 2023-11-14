package com.example.communication;

import com.example.communication.restTemplate.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CommunicationApplication {
    public static void main(String[] args) {
        SpringApplication.run(CommunicationApplication.class, args);
    }
}
