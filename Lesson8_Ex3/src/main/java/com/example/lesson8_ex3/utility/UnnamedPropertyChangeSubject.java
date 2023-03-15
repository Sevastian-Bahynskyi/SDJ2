package com.example.lesson8_ex3.utility;

import java.beans.PropertyChangeListener;

public interface UnnamedPropertyChangeSubject
{
   void addListener(PropertyChangeListener listener);
   void removeListener(PropertyChangeListener listener);
}