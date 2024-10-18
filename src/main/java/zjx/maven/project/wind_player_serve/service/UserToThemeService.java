package zjx.maven.project.wind_player_serve.service;

import zjx.maven.project.wind_player_serve.model.UserToTheme;

public interface UserToThemeService {
    UserToTheme getByUid(String uid);

    UserToTheme update(UserToTheme userToTheme);

    String insert(String uid);
}
