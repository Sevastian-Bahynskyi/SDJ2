package com.example.lesson8_ex3;

import com.example.lesson8_ex3.mediator.*;
import com.example.lesson8_ex3.model.*;

import java.io.IOException;

public class UppercaseMain
{
  public static void main(String args[]) throws IOException
  {
    Converter converter = new Converter();
    Model model = new ModelManager("Server", converter);

    UppercaseServer server = new UppercaseServer(model);
    Thread serverThread = new Thread(server);
    serverThread.start();
    // starting server
  }
}