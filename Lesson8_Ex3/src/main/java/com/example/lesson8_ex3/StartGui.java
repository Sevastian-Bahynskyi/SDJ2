package com.example.lesson8_ex3;

import com.example.lesson8_ex3.mediator.UppercaseClient;
import com.example.lesson8_ex3.model.Model;
import com.example.lesson8_ex3.model.ModelManager;
import com.example.lesson8_ex3.view.ViewFactory;
import com.example.lesson8_ex3.view.ViewHandler;
import com.example.lesson8_ex3.view_model.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

import java.util.Scanner;

public class StartGui extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String userName = scanner.nextLine();
        Model model = new ModelManager(userName);
        model.connect();
        ViewModelFactory viewModelFactory = new ViewModelFactory(model);
        ViewHandler viewHandler = new ViewHandler(viewModelFactory);
        viewHandler.start(primaryStage);
    }
}
