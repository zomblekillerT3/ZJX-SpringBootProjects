package zjx.maven.project.wind_player_serve.service;


public interface UserToThemeWeightService {
    int insert(String uid,int tid);

    int updateByUidTidNow(String uid, int tid,int setNum);

    int updateByUidTidHistory(String uid, int tid,int setNum);

    int getByUid(String uid);
}
