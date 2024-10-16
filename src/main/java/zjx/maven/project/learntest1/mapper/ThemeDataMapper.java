package zjx.maven.project.learntest1.mapper;

import org.apache.ibatis.annotations.Mapper;
import zjx.maven.project.learntest1.model.ThemeData;

import java.util.List;

@Mapper
public interface ThemeDataMapper {
    List<ThemeData> getAll();
}
