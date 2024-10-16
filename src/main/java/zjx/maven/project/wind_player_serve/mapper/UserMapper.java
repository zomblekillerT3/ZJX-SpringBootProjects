package zjx.maven.project.wind_player_serve.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import zjx.maven.project.wind_player_serve.model.User;

public interface UserMapper {
    @Select("select * from user where name = #{name} and password =#{password} ")
    User getUserByNameAndPassword(@Param("name")String name, @Param("password") String password);
}
