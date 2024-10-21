package zjx.maven.project.wind_player_serve.Exception;

import java.io.Serial;

public class MyException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    protected int errorCode;
    /**
     * 错误信息
     */
    protected String errorMsg;

    public MyException() {
        super();
    }

    public MyException(StatusCode statusCode) {
        this.errorCode = statusCode.getCode();
        this.errorMsg = statusCode.getMsg();
    }

    public MyException(StatusCode statusCode, Throwable cause) {
        this.errorCode = statusCode.getCode();
        this.errorMsg = statusCode.getMsg();
    }

    public MyException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public MyException(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public MyException(int errorCode, String errorMsg, Throwable cause) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public String getMessage() {
        return errorMsg;
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }

}


