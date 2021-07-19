package com.DXTech.YQDL.utils;

public class ResponseUtil {

    public static <T> ResponseInfo<T>  defineSuccess(Integer code, T data) {
        ResponseInfo result = new ResponseInfo<>();
        return result.setCode(code).setData(data);
    }

    public static <T> ResponseInfo<T> success(T data) {
        ResponseInfo result = new ResponseInfo();
        result.setCode(ResponseEnum.SUCCESS.code).setData(data);
        return result;
    }

    public static <T> ResponseInfo<T> fail(String msg) {
        ResponseInfo result = new ResponseInfo();
        result.setCode(ResponseEnum.FAIL.code).setMsg(msg);
        return result;
    }

    public static <T> ResponseInfo<T> defineFail(int code, String msg){
        ResponseInfo result = new ResponseInfo();
        result.setCode(code).setMsg(msg);
        return result;
    }

    public static <T> ResponseInfo<T> define(int code, String msg, T data){
        ResponseInfo result = new ResponseInfo();
        result.setCode(code).setMsg(msg).setData(data);
        return result;
    }
}
