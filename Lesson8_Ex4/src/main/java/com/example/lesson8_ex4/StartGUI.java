package com.example.lesson8_ex4;

import com.example.lesson8_ex4.mediator.LoginClient;
import com.example.lesson8_ex4.model.UserModel;
import com.example.lesson8_ex4.model.UserModelManager;
import com.example.lesson8_ex4.view.ViewHandler;
import com.example.lesson8_ex4.view_model.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class StartGUI extends Application
{
    @Override
    public void start(Stage primaryStage) throws Exception
    {
        LoginClient client = new LoginClient();
        client.connect();
        UserModel model = client.getModel();
        model.setServerModel(client); // todo: check if decision is write
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
    }
}
