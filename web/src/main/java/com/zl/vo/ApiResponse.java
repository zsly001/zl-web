package com.zl.vo;

public class ApiResponse<T> {

    private int code;

    private T data;

    private String msg;

    public static <T> ApiResponse<T> ok(){
        return ok(null);
    }

    public static <T> ApiResponse<T> ok(T data){
        return build(1000,data,"success");
    }

    public static <T> ApiResponse<T> build(int code,T data,String msg){
        ApiResponse<T> response = new ApiResponse<>();
        response.setCode(code);
        response.setData(data);
        response.setMsg(msg);
        return response;
    }

    public static <T> ApiResponse<T> error(String msg){
        return error(2000,msg);
    }

    public static <T> ApiResponse<T> error(int code,String msg){
        return build(code,null,msg);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
