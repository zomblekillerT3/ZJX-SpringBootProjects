package zjx.maven.project.wind_player_serve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zjx.maven.project.wind_player_serve.model.UserToTheme;
import zjx.maven.project.wind_player_serve.service.Result;
import zjx.maven.project.wind_player_serve.service.UserToThemeService;

import static zjx.maven.project.wind_player_serve.service.ResultCode.*;

@RestController
@RequestMapping("/usertotheme")
public class UserToThemeController {
    @Autowired
    private UserToThemeService userToThemeService;

    //检查用户是否存在，不存在添加，存在返回err401
    @GetMapping("/check")
    public Result check(String uid){
           if(userToThemeService.getByUid(uid) == null) {
               return new Result(userToThemeService.insert(uid));
           }
        else{
               return new Result(USEREERROR,userToThemeService.getByUid(uid));}
        }

    //用户更改主题
    @PostMapping("settheme")
    public Result update(UserToTheme userToTheme)throws Exception {
        try {
            userToThemeService.update(userToTheme);
                return new Result(userToTheme);
        }catch (Exception e) {
            return new Result(USERTOTHEMEERROR);
        }
    }
}
