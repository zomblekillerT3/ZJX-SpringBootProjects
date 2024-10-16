package zjx.maven.project.wind_player_serve.mapper;

import org.apache.ibatis.annotations.Mapper;
import zjx.maven.project.wind_player_serve.model.ThemeData;

import java.util.List;

@Mapper
public interface ThemeDataMapper {
    List<ThemeData> getAll();
}
