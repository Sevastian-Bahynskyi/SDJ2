package com.example.lesson8_ex4.model;

import java.io.Serializable;

public class Email implements Serializable
{
    private final String username;
    private final String domain;

    public Email(String username, String domain) {
        this.username = username;
        this.domain = domain;
    }

    public String getUsername() {
        return username;
    }

    public String getDomain() {
        return domain;
    }

    @Override
    public String toString() {
        return username + '@' + domain;
    }
}
