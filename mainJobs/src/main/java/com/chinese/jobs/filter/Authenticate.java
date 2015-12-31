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
    public boolean authentication(String authCredentials) {

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

        return CredentialManager.validateUser(new User(username,password));
    }
}
