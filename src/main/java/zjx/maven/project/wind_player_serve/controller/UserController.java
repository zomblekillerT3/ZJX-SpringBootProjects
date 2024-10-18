package zjx.maven.project.wind_player_serve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import zjx.maven.project.wind_player_serve.mapper.UserMapper;
import zjx.maven.project.wind_player_serve.model.User;

@RestController
public class UserController {
    @Autowired
    UserMapper userMapper;

    @PostMapping("/login")
    public User login(@RequestBody User user) {
       User dbuser = userMapper.getUserByNameAndPassword(user.getName(), user.getPassword());
       return dbuser;
    }
}
