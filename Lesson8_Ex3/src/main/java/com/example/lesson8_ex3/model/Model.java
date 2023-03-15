package com.example.lesson8_ex3.model;


import com.example.lesson8_ex3.mediator.ServerModel;
import com.example.lesson8_ex3.utility.UnnamedPropertyChangeSubject;

import java.io.IOException;

public interface Model extends UnnamedPropertyChangeSubject
{
  String convert(String source) throws Exception;
  void connect() throws IOException;
  void addLog(String log);

  String getLastLog();
}
