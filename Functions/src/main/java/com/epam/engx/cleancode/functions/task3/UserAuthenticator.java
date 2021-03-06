package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.thirdpartyjar.SessionManager;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.UserService;

public abstract class UserAuthenticator implements UserService {

    private SessionManager sessionManager;

    public boolean login(String userName, String password) {
        return loginUser(getUserByName(userName), password);
    }

    private boolean loginUser(User user, String password) {
        boolean isLoggedIN=false;
        if (isPasswordCorrect(user, password)) {
            sessionManager.setCurrentUser(user);
            isLoggedIN=true;
        }
        return isLoggedIN;
    }


}
