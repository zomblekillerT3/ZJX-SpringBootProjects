package zjx.maven.project.learntest1.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@Controller
public class HelloController {
    @GetMapping(value = "/helloq")
    public String hello() {
        return "Hello Spring Boot!";
    }
}
