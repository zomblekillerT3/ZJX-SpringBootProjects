package zjx.maven.project.learntest1.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zjx.maven.project.learntest1.model.ThemeData;

@RestController
public class TestController {
    @PostMapping("/test")
    public void test(@RequestBody ThemeData test) {
        System.out.println(test.getId());
        System.out.println();
    }
}
