package com.example.demo.Controller;

import com.example.demo.Entity.Hello;
import com.example.demo.Repository.HelloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class HelloController {
    @Autowired
    private HelloRepository helloRepository;

    @GetMapping("/sayHello")
    public Hello sayHello() {
        return helloRepository.findHelloById(1L);
    }
}