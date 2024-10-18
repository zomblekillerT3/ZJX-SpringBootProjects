package zjx.maven.project.wind_player_serve.service;

import lombok.Getter;

@Getter
public enum ResultCode implements StatusCode {
    SUCCESS(200,"请求成功"),
    FAILED(400,"请求失败"),
    USEREERROR(401,"用户已存在"),
    USERTOTHEMEERROR(402,"主题不存在"),
    TEST(10000,"test");

    private int code;
    private String msg;
    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
