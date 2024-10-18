package zjx.maven.project.wind_player_serve.mapper;

import org.apache.ibatis.annotations.Mapper;
import zjx.maven.project.wind_player_serve.model.UserToTheme;

@Mapper
public interface UserToThemeMapper {
    //根据uid查询数据
    UserToTheme getByUid(String uid);
    //添加用户
    int insert(String uid);
    //更改用户主题
    int update(UserToTheme userToTheme);
}
