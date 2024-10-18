package zjx.maven.project.wind_player_serve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zjx.maven.project.wind_player_serve.model.ThemeData;
import zjx.maven.project.wind_player_serve.service.Result;
import zjx.maven.project.wind_player_serve.service.ThemeService;

@RestController
@RequestMapping("/usertheme")
public class UserThemeController {
    @Autowired
    private ThemeService themeService;

    @PostMapping("/insert")
    public Result insert(ThemeData themeData) {
        return new Result(themeService.insert(themeData));
    }

    @PostMapping("/delete")
    public Result delete(int tid,String uid) {
       return new Result(themeService.deleteByTid(tid,uid));
    }


    @GetMapping("/get")
    public Result getThemeDataById(int tid) {
        return new Result(themeService.getThemeDataByTid(tid));
    }
    @GetMapping("/getall")
    public Result getAll() {
        themeService.getall();
        return new Result(themeService.getall());
    }
}
