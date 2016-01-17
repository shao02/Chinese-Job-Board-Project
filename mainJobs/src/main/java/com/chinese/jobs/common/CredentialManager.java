package com.chinese.jobs.common;

import com.chinese.jobs.model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by xu_s on 12/30/15.
 */
public class CredentialManager {
    private static final Map<String,User> allUsers = new ConcurrentHashMap<String, User>();

    static {
        try {
            addUser(new User("yali","yaqiang"));
        }catch (Exception e){
        }
    }

    static public void addUser(User user) throws Exception{
        if(isUserNameUsed(user.getUserAccountName()))
            throw new Exception();
        allUsers.put(user.getUserAccountName(),user);
    }

    static public boolean validateUser(User user){
        return (isUserNameUsed(user.getUserAccountName()) && allUsers.get(user.getUserId()).getUserAccountPassword()
                                                                        .equals(user.getUserAccountPassword()));
    }

    static public void deleteUser(User user){
        allUsers.remove(user.getUserId());
    }

    static public void updatePassword(String userId,String password) throws Exception{
        if(!isUserNameUsed(userId))
            throw new Exception();
        allUsers.put(userId,new User(userId,password));
    }
}
