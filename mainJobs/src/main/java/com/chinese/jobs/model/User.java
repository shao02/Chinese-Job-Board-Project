package com.chinese.jobs.model;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

/**
 * Created by xu_s on 12/30/15.
 */
public class User {
    private String password;
    private String userId;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User(){
    }

    public User(String user_Id,String password) {
        this.password = password;
        this.userId = user_Id;
    }

    public String convertToCode() throws UnsupportedEncodingException {
        String userIdPassword = userId + ":"+password;
        String userIdPasswordbase64encodedString = Base64.getEncoder()
                .encodeToString(userIdPassword.getBytes("utf-8"));
        return "Basic "+ userIdPasswordbase64encodedString;
    }
}
