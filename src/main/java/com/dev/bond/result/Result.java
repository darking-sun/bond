package com.dev.bond.result;

import org.slf4j.LoggerFactory;

public class Result<T> {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(Result.class);

    private static final long serialVersionUID = -1802122468331526708L;
    private int code;
    private String message;
    private T data ;

    public Result(){}

    public Result(int code) {
        this.code = code;
    }


    public Result(int code, String message){
        this.code = code;
        this.message = message;
    }

    public Result(int code,String message,T data){
        this.code = code;
        this.data = data;
        this.message = message;
    }
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
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

//    public void putData(String key, Object value) {
////        data.put(key, value);
////    }
////
////    public void removeData(String key) {
////        data.remove(key);
////    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}

