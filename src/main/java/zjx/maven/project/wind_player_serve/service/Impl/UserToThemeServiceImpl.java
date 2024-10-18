package zjx.maven.project.wind_player_serve.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjx.maven.project.wind_player_serve.mapper.UserToThemeMapper;
import zjx.maven.project.wind_player_serve.model.UserToTheme;
import zjx.maven.project.wind_player_serve.service.UserToThemeService;

@Service
public class UserToThemeServiceImpl implements UserToThemeService {
    @Autowired
    private UserToThemeMapper userToThemeMapper;

    @Override
    public UserToTheme getByUid(String uid) {
        return userToThemeMapper.getByUid(uid);
    }

    @Override
    public UserToTheme update(UserToTheme userToTheme) {
        userToThemeMapper.update(userToTheme);
        return userToTheme;
    }

    @Override
    public String insert(String uid) {
        userToThemeMapper.insert(uid);
        return uid;
    }
}
