package dk.via.mvvm.viewmodel;

import dk.via.mvvm.model.User;
import dk.via.mvvm.model.UserModel;
import dk.via.mvvm.model.UserModelManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class MessageViewModel implements PropertyChangeListener{
    private final UserModel model;
    private final StringProperty userNumber;
    private final StringProperty userInfo;

    public MessageViewModel(UserModel model) {
        this.model = model;
        this.userNumber = new SimpleStringProperty();
        this.userInfo = new SimpleStringProperty();
        UserModelManager modelManager = (UserModelManager) model;
        modelManager.addPropertyChangeListener("users", this);
    }

    public void bindUserNumber(StringProperty property) {
        property.bind(userNumber);
    }
    public void bindUserInfo(StringProperty property) {
        property.bind(userInfo);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        userNumber.set("You have created " + model.getUserCount() +
                (model.getUserCount() == 1? " user" : "users"));
        User user = model.getLastUser();
        userInfo.set(String.format("Username: %s\nPassword: %s\nEmail: %s",
                user.getUsername(), user.getPassword(), user.getEmail().toString()));
    }
}
