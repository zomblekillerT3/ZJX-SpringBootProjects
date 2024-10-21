package zjx.maven.project.wind_player_serve.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

// 定义全局异常处理类
@ControllerAdvice
public class GlobalExceptionHandler {

    // 处理自定义的业务异常
    @ExceptionHandler(MyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<Map<String, Object>> handleResult(MyException mex) {
        Map<String, Object> map = new HashMap<>();
        map.put("code",mex.getErrorCode());
        map.put("msg",mex.getErrorMsg());
//        map.put("data",mex.getData());
        return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
    }

    // 处理其他所有未捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<Map<String, String>> handleGlobalException(Exception ex) {
        Map<String, String> response = new HashMap<>();
        response.put("error", "服务器内部错误");
        response.put("message", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
