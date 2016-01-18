package com.chinese.jobs.common;

import com.chinese.jobs.model.Job;
import com.chinese.jobs.model.User;
import com.chinese.persistence.dbUtil;

import java.util.List;
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
        if(dbUtil.isUserNameUsed(user.getUserAccountName()))
            throw new Exception();
        dbUtil.addDBObject(user);
    }

    static public boolean validateUser(User user){
        return dbUtil.isUserNameUsed(user.getUserAccountName());
    }

    static public void deleteUser(long userId){
        dbUtil.deleteUser(userId);
    }

    static public void updatePassword(long userId,String password) throws Exception{
        User cur = dbUtil.loadUser(userId);
        cur.setUserAccountPassword(password);
        dbUtil.updateDBObject(cur);
    }

    static public List<Job> loadJobs(long userId){
        return dbUtil.loadJobForUser(userId);
    }

}
