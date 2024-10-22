package zjx.maven.project.wind_player_serve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zjx.maven.project.wind_player_serve.Exception.MyException;
import zjx.maven.project.wind_player_serve.mapper.UserToThemeWeightMapper;
import zjx.maven.project.wind_player_serve.model.UserToTheme;
import zjx.maven.project.wind_player_serve.Exception.Result;
import zjx.maven.project.wind_player_serve.service.UserToThemeService;
import zjx.maven.project.wind_player_serve.service.UserToThemeWeightService;

import static zjx.maven.project.wind_player_serve.Exception.ResultCode.*;

@RestController
@RequestMapping("/usertotheme")
public class UserToThemeController {
    @Autowired
    private UserToThemeService userToThemeService;
    @Autowired
    private UserToThemeWeightService userToThemeWeightService;
    @Autowired
    private UserToThemeWeightMapper userToThemeWeightMapper;

    @GetMapping("/check")
    public Result check(String uid){
           if(userToThemeService.getByUid(uid) == null) {
               userToThemeWeightMapper.insert(uid,-1);
               return new Result(userToThemeService.insert(uid));
           }
        else{
               throw  new MyException(USEREERROR);}
        }

    @PostMapping("settheme")
    public Result update(UserToTheme userToTheme) {
        try {
            userToThemeService.update(userToTheme);
            userToThemeWeightService.insert(userToTheme.getUid(),userToTheme.getTid());
                return new Result(userToTheme);
        }catch (Exception e) {
            throw new MyException(USERTOTHEMEERROR);
        }
    }

}
