package com.epam.engx.cleancode.functions.task3;

import com.epam.engx.cleancode.functions.task3.thirdpartyjar.Controller;
import com.epam.engx.cleancode.functions.task3.thirdpartyjar.User;

public abstract class UserController implements Controller {

    private UserAuthenticator userAuthenticator;

    public void authenticateUser(String userName, String password) {
       if( userAuthenticator.login(userName, password)) {

           generateFailLoginResponse();
       }
        else {
           generateSuccessLoginResponse(userName);
       }
    }


}
