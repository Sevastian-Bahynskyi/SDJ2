package com.example.lesson8_ex4.model;

import com.example.lesson8_ex4.mediator.ServerModel;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface UserModel extends Serializable
{
    void addUser(String username, String password, String email) throws IllegalArgumentException, IllegalStateException, IOException;

    User getUser(String username);

    User getLastUser();

    int getUserCount();

    List<User> getUserList();

    void setServerModel(ServerModel model);
}
