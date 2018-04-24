package com.ilabservice.intelab.restful.object;

public class RestObject {

    private String message;
    private Integer code;
    private Object data;

    public RestObject(Object data){
        this.data = data;
        message = "Succeed";
        code = 0;
    }

    public RestObject(Object data, String message, Integer code){
        this.data = data;
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
