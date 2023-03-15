package Ex2;

import java.io.Serializable;

public class Login implements Serializable
{
    private String username;
    private String password;

    public Login(String username, String password)
    {
        this.password = password;
        this.username = username;
    }

    public String getPassword()
    {
        return password;
    }

    public String getUsername()
    {
        return username;
    }

    public boolean equals(Object obj)
    {
        if(obj == null || obj.getClass() != getClass())
            return false;

        Login l = (Login) obj;
        return l.username.equals(username) && l.password.equals(password);
    }

    public String toString()
    {
        return "Username: " + username + "; Password: " + password;
    }
}
