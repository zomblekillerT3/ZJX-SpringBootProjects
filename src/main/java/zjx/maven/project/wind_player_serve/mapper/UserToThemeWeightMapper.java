package zjx.maven.project.wind_player_serve.mapper;

import org.apache.ibatis.annotations.Mapper;
import zjx.maven.project.wind_player_serve.model.UserToThemeWeight;

@Mapper
public interface UserToThemeWeightMapper {
    int insert(String uid,int tid);

    UserToThemeWeight getOnly(String uid,int tid);

    int getByUid(String uid);

    int updateByUidTidNow(String uid, int tid,int setNum);

    int updateByUidTidHistory(String uid, int tid,int setNum);
}
