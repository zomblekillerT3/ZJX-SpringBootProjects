package zjx.maven.project.wind_player_serve.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zjx.maven.project.wind_player_serve.model.ThemeData;

@RestController
public class TestController {
    @PostMapping("/test")
    public void test(@RequestBody ThemeData test) {
        System.out.println();
    }
}
