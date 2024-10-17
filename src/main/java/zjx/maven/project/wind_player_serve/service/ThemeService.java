package zjx.maven.project.wind_player_serve.service;

import jakarta.servlet.http.HttpServletResponse;
import zjx.maven.project.wind_player_serve.model.ThemeData;

import java.io.IOException;
import java.util.List;

public interface ThemeService {
    List<ThemeData> getall();
    void export(HttpServletResponse reponse) throws IOException;

    ThemeData insert(ThemeData themeData);

    int updateByTid(ThemeData themeData);

    int deleteByTid(int id);

    ThemeData getThemeDataByTid(int id);
}

