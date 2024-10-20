package zjx.maven.project.wind_player_serve.mapper;

import org.apache.ibatis.annotations.Mapper;
import zjx.maven.project.wind_player_serve.model.ThemeData;

import java.util.List;

@Mapper
public interface ThemeDataMapper {
    /*
    查询所有主题
     */
    List<ThemeData> getAll();
    /*
    插入新主题
    */
    int insert(ThemeData themeData);
    /*
    根据id更改主题
     */
    int updateByTid(ThemeData themeData);
    /*
    根据id删除主题
     */
    int deleteByTid(int tid,String creator);
    /*
    根据id查询主题
     */
    ThemeData getThemeDataByTid(int tid);
    /*
    分页查询
     */
    List<ThemeData> getThemeDataByPage(int limit, int offset);


}
