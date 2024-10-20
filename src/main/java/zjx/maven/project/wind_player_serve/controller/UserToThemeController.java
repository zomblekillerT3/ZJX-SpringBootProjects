package zjx.maven.project.wind_player_serve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zjx.maven.project.wind_player_serve.Exception.MyException;
import zjx.maven.project.wind_player_serve.model.UserToTheme;
import zjx.maven.project.wind_player_serve.Exception.Result;
import zjx.maven.project.wind_player_serve.service.UserToThemeService;

import static zjx.maven.project.wind_player_serve.Exception.ResultCode.*;

@RestController
@RequestMapping("/usertotheme")
public class UserToThemeController {
    @Autowired
    private UserToThemeService userToThemeService;

    @GetMapping("/check")
    public Result check(String uid){
           if(userToThemeService.getByUid(uid) == null) {
               return new Result(userToThemeService.insert(uid));
           }
        else{
               throw  new MyException(USEREERROR);}
        }

    @PostMapping("settheme")
    public Result update(UserToTheme userToTheme) {
        try {
            userToThemeService.update(userToTheme);
                return new Result(userToTheme);
        }catch (Exception e) {
            throw new MyException(USERTOTHEMEERROR);
        }
    }
}
