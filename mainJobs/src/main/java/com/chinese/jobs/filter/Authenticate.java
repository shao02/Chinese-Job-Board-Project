package com.chinese.jobs.filter;

import com.chinese.jobs.common.CredentialManager;
import com.chinese.jobs.model.User;

import java.io.IOException;
import java.util.Base64;
import java.util.StringTokenizer;

/**
 * Created by xu_s on 12/30/15.
 */
public class Authenticate {
    static public String getUser(String auth){
        final String encodedUserPassword = auth.replaceFirst("Basic ", "");
        String usernameAndPassword = null;
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(
                    encodedUserPassword);
            usernameAndPassword = new String(decodedBytes, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final StringTokenizer tokenizer = new StringTokenizer(
                usernameAndPassword, ":");
       return tokenizer.nextToken();
    }

    static public boolean authentication(String authCredentials) {

        if (null == authCredentials)
            return false;
        final String encodedUserPassword = authCredentials.replaceFirst("Basic ", "");
        String usernameAndPassword = null;
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(
                    encodedUserPassword);
            usernameAndPassword = new String(decodedBytes, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        final StringTokenizer tokenizer = new StringTokenizer(
                usernameAndPassword, ":");
        final String username = tokenizer.nextToken();
        final String password = tokenizer.nextToken();

        User curUser = new User();
        curUser.setUserAccountName(username);
        curUser.setUserAccountPassword(password);
        return CredentialManager.validateUser(curUser);
    }
}
