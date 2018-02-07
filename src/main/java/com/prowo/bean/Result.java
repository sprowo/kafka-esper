package com.prowo.bean;

/**
 * @author prowo
 * @date 2018/2/7
 */
public class Result<T> {

    private String code = "0000";

    private String message = "ok";

    private T data;

    public Result() {

    }

    public Result(String code, String message) {
        this.code = code;
        this.message = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}