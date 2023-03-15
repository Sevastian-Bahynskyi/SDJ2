package Ex1;

import java.beans.PropertyChangeListener;

public interface LoginClient
{
    void login(String username, String password);
    void addPropertyChangeListener(PropertyChangeListener listener);
    void removePropertyChangeListener(PropertyChangeListener listener);
}
