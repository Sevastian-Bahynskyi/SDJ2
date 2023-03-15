package com.example.lesson8_ex4.mediator;

import java.io.IOException;

public interface ServerModel
{
    void connect() throws IOException, ClassNotFoundException;
    void disconnect() throws IOException;
    void addUser(String username, String password, String email) throws IOException;
}
