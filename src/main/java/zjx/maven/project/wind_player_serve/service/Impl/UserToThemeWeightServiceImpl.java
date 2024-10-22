package zjx.maven.project.wind_player_serve.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjx.maven.project.wind_player_serve.mapper.UserToThemeWeightMapper;
import zjx.maven.project.wind_player_serve.service.UserToThemeWeightService;

@Service
public class UserToThemeWeightServiceImpl implements UserToThemeWeightService {
    @Autowired
    private UserToThemeWeightMapper userToThemeWeightMapper;

    @Override
    public int insert(String uid, int tid) {
        if(userToThemeWeightMapper.getOnly(uid, tid) == null){
            userToThemeWeightMapper.insert(uid, tid);
        }
      return 0;
    }

    @Override
    public int updateByUidTidNow(String uid, int tid,int setNum) {
      return userToThemeWeightMapper.updateByUidTidNow(uid, tid,setNum);
    }

    @Override
    public int updateByUidTidHistory(String uid, int tid, int setNum) {
      return userToThemeWeightMapper.updateByUidTidHistory(uid, tid,setNum );
    }

    @Override
    public int getByUid(String uid) {
        return userToThemeWeightMapper.getByUid(uid);
    }
}
