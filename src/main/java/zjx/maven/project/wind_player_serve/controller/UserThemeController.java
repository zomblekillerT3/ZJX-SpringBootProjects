package zjx.maven.project.wind_player_serve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import zjx.maven.project.wind_player_serve.model.ThemeData;
import zjx.maven.project.wind_player_serve.service.ThemeService;

@RestController
@RequestMapping("/Usertheme")
public class UserThemeController {
    @Autowired
    private ThemeService themeService;

    @PostMapping("/insert")
    public ThemeData insert(ThemeData themeData) {
        return themeService.insert(themeData);
    }

    @PostMapping("/delete")
    public String delete(int tid) {
        int result = themeService.deleteByTid(tid);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    @GetMapping("/udpate")
    public String udpate(ThemeData themeData) {
        int result = themeService.updateByTid(themeData);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    @GetMapping("/get")
    public ThemeData getThemeDataById( int tid) {
        return themeService.getThemeDataByTid(tid);
    }
}
