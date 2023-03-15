package com.example.lesson8_ex4.view_model;

import com.example.lesson8_ex4.model.UserModel;
import com.example.lesson8_ex4.model.UserModelManager;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class GoodbyeViewModel implements PropertyChangeListener
{
    private UserModel model;
    private StringProperty userNumber;

    public GoodbyeViewModel(UserModel model)
    {
        this.model = model;
        userNumber = new SimpleStringProperty();
        UserModelManager modelManager = (UserModelManager) model;
        modelManager.addPropertyChangeListener("users", this);
    }


    public void bindUserNumber(StringProperty property)
    {
        property.bind(userNumber);
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        userNumber.set("User number: " + model.getUserCount());
    }
}
