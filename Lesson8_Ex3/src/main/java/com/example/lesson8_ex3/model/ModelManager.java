package com.example.lesson8_ex3.model;

import com.example.lesson8_ex3.mediator.ServerModel;
import com.example.lesson8_ex3.mediator.UppercaseClient;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.IOException;
import java.io.Serializable;

public class ModelManager implements Model, Serializable
{
  private ServerModel serverModel;
  private PropertyChangeSupport support;
  private Converter converter;

  public ModelManager(String userName, Converter converter) throws IOException
  {
    serverModel = new UppercaseClient(userName);
    this.support = new PropertyChangeSupport(this);
    this.converter = converter;
  }

  public ModelManager(String userName) throws IOException
  {
    serverModel = new UppercaseClient(userName);
    this.support = new PropertyChangeSupport(this);
  }

  public void connect() throws IOException
  {
    serverModel.connect();
  }

  @Override
  public String convert(String source)
  {
    String reply = null;
    try
    {
      reply = serverModel.convert(source).toUpperCase();
    } catch (IOException e)
    {
      // todo -> maybe notify view model to set error property
    }
    return reply;
  }

  @Override
  public void addLog(String log)
  {
    converter.addLog(log);
  }

  public String getLastLog()
  {
    return converter.getLastLog();
  }

  @Override
  public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override
  public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

}
