package com.wb.web.response;

public class ResponseBody{
    private Object data;
    private int code;

    public ResponseBody() {
    }

    public ResponseBody(Object data, int code) {
        this.data = data;
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "ResponseBody{" +
                "data=" + data +
                ", code=" + code +
                '}';
    }
}
