package com.chinese.jobs.response;

/**
 * Created by xu_s on 12/31/15.
 */
public class ResponseJson {
    private String code;
    private String msg;

    public ResponseJson(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
