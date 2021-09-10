package com.example.citasWebJava.dto;

public class MessageDTO {

    private int code;
    private Object data;

    public MessageDTO(int _code, Object _data) {
        this.code = _code;
        this.data = _data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
