package com.example.communication.restTemplate.controller;

import com.example.communication.restTemplate.service.RestTemplateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ApiContoller {

    private final RestTemplateService service;
    @GetMapping("/first")
    public String first(){
        return service.first();
    }

}
