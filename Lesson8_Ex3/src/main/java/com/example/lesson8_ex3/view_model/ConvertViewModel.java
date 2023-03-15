package com.example.lesson8_ex3.view_model;

import com.example.lesson8_ex3.model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ConvertViewModel
{
    private Model model;
    private StringProperty request;
    private StringProperty reply;
    private StringProperty error;
//    private PropertyChangeSupport support;

    public ConvertViewModel(Model model){
        this.model = model;
        request = new SimpleStringProperty();
        reply = new SimpleStringProperty();
        error = new SimpleStringProperty();
//        this.support = new PropertyChangeSupport(this);
    }

    public void convert()
    {
        try{
            reply.set(model.convert(request.get()));
            error.set(null);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void bindRequest(StringProperty property)
    {
        property.bindBidirectional(request);
    }

    public void bindReply(StringProperty property)
    {
        property.bindBidirectional(reply);
    }

    public void bindError(StringProperty property)
    {
        property.bindBidirectional(error);
    }

//    public void addPropertyChangeListener(PropertyChangeListener listener)
//    {
//        support.addPropertyChangeListener(listener);
//    }
//
//    public void removePropertyChangeListener(PropertyChangeListener listener)
//    {
//        support.removePropertyChangeListener(listener);
//    }
}
