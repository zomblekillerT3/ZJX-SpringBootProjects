package zjx.maven.project.wind_player_serve;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("zjx.maven.project.wind_player_serve.mapper")//扫描mapper的位置
public class LearnTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(LearnTest1Application.class, args);
    }

}
