package zjx.maven.project.wind_player_serve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zjx.maven.project.wind_player_serve.model.ThemeData;
import zjx.maven.project.wind_player_serve.service.Result;
import zjx.maven.project.wind_player_serve.service.ThemeService;

import static zjx.maven.project.wind_player_serve.service.ResultCode.USERTHEMEERROR;

@RestController
@RequestMapping("/usertheme")
public class UserThemeController {
    @Autowired
    private ThemeService themeService;

    //用户向共享表添加主题
    @PostMapping("/insert")
    public Result insert(ThemeData themeData) {
        if(themeService.getThemeDataOne(themeData) == null){
            return new Result(themeService.insert(themeData));
        }
        else{
            return new Result(USERTHEMEERROR);
        }
    }

    //用户从共享表删除主题
    @PostMapping("/delete")
    public Result delete(int tid,String uid) {
       return new Result(themeService.deleteByTid(tid,uid));
    }

    //根据创建者和主题名查询主题
    @GetMapping("/get")
    public Result getThemeDataByOne(ThemeData themeData) {
        return new Result(themeService.getThemeDataOne(themeData));
    }

    //查询所有主题
    @GetMapping("/getall")
    public Result getAll() {
        themeService.getall();
        return new Result(themeService.getall());
    }
}
