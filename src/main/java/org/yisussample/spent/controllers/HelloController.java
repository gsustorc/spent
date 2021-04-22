package org.yisussample.spent.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController("/")
public class HelloController {

    @RequestMapping("/")
    public String main() {
        return "Greetings from Spring Boot! Main!";
    }

    @RequestMapping("/index")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/map")
    public Map<String, Object> map() {
        return Stream.of(new String[][] {
                { "Hello", "World" },
                { "John", "Doe" },
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
    }
}
