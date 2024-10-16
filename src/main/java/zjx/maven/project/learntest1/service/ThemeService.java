package zjx.maven.project.learntest1.service;

import jakarta.servlet.http.HttpServletResponse;
import zjx.maven.project.learntest1.model.ThemeData;

import java.io.IOException;
import java.util.List;

public interface ThemeService {
    List<ThemeData> getall();
    void export(HttpServletResponse reponse) throws IOException;
}

