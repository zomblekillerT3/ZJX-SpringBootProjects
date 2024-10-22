package zjx.maven.project.wind_player_serve.algorithm;

import org.springframework.beans.factory.annotation.Autowired;
import zjx.maven.project.wind_player_serve.mapper.UserToThemeMapper;
import zjx.maven.project.wind_player_serve.mapper.UserToThemeWeightMapper;
import zjx.maven.project.wind_player_serve.model.ThemeData;
import zjx.maven.project.wind_player_serve.model.UserToTheme;
import zjx.maven.project.wind_player_serve.service.ThemeService;
import zjx.maven.project.wind_player_serve.service.UserToThemeService;
import zjx.maven.project.wind_player_serve.service.UserToThemeWeightService;

public class ThemeWeightManager {
    UserToThemeService userToThemeService;

    UserToThemeWeightService userToThemeWeightService;

    ThemeService themeService;
    public void useTheme(UserToTheme userToTheme) {
        String currentUid = userToTheme.getUid();
        // 获取用户当前主题
        int currentTid = userToThemeService.getByUidReturnTid(userToTheme.getUid());
        int changedTid =  userToTheme.getTid();
            // 用户切换主题
            if (currentTid != changedTid) {
                // 减少当前主题的权重
                userToThemeWeightService.updateByUidTidNow(currentUid,currentTid,0);
                // 更新为使用过权重（仅一次）
                userToThemeWeightService.updateByUidTidHistory(currentUid,currentTid,1);
                //增加更改后主题的权重
                userToThemeWeightService.updateByUidTidNow(currentUid,changedTid,1);
            }
        }
        public void changeThemeWeight(ThemeData themeData) {

        }
    }

