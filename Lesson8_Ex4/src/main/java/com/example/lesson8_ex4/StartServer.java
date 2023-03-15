package com.example.lesson8_ex4;

import com.example.lesson8_ex4.mediator.LoginServer;
import com.example.lesson8_ex4.model.UserModel;
import com.example.lesson8_ex4.model.UserModelManager;

import java.io.IOException;

public class StartServer
{
    public static void main(String[] args) throws IOException, ClassNotFoundException
    {
        UserModel userModel = new UserModelManager();
        LoginServer loginServer = new LoginServer(userModel);
        loginServer.run();
    }
}
