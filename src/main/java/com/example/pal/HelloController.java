package com.example.pal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class HelloController {

    @GetMapping("/")
    public String sayHello() {
        return "hello";
    }

    @GetMapping("/{name}")
    public String sayHello(@PathParam("name") String name) {
        return "hello " + name;
    }
}
