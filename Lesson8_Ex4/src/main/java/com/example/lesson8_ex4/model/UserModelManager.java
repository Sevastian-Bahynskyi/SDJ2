package com.example.lesson8_ex4.model;

import com.example.lesson8_ex4.mediator.LoginClient;
import com.example.lesson8_ex4.mediator.ServerModel;
import com.example.lesson8_ex4.model.validation.PasswordValidator;
import com.example.lesson8_ex4.model.validation.UsernameValidator;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserModelManager implements UserModel
{
    private ServerModel serverModel;
    private final List<User> users;
    private PropertyChangeSupport support;

    public UserModelManager() throws IOException, ClassNotFoundException
    {
        this.users = new ArrayList<>();
        support = new PropertyChangeSupport(this);
    }


    public void setServerModel(ServerModel model)
    {
        this.serverModel = model;
    }


    public List<User> getUserList()
    {
        return users;
    }

    public void addUser(String username, String password, String emailString) throws IOException
    {
        users.add(new User(username, password, EmailFactory.createEmail(emailString)));
        serverModel.addUser(username, password, emailString);
        support.firePropertyChange("users", null, users);

    }

    public User getUser(String username) {
        for(User user: users) {
            if (username.equals(user.getUsername())) {
                return user;
            }
        }
        return null;
    }

    public User getLastUser() {
        if (users.isEmpty())
            return null;
        else
            return users.get(users.size() - 1);
    }

    public int getUserCount() {
        return users.size();
    }

    public void addPropertyChangeListener(String propertyName, PropertyChangeListener listener)
    {
        support.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener)
    {
        support.removePropertyChangeListener(listener);
    }
}
