package com.example.lesson8_ex3.view;

import com.example.lesson8_ex3.view_model.ViewModelFactory;
import javafx.scene.Scene;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

public class ViewHandler
{
    private Stage primaryStage;
    private Scene currentScene;
    private ViewFactory viewFactory;


    public ViewHandler(ViewModelFactory viewModelFactory)
    {
        viewFactory = new ViewFactory(this, viewModelFactory);
    }

    public void start(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        currentScene = new Scene(viewFactory.load(ViewFactory.CONVERT));
        openView(ViewFactory.CONVERT);
    }

    public void openView(String id)
    {
        Region root = viewFactory.load(id);
        currentScene.setRoot(root);
        if (root.getUserData() == null) {
            primaryStage.setTitle("");
        } else {
            primaryStage.setTitle(root.getUserData().toString());
        }
        primaryStage.setScene(currentScene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    public void closeView()
    {
        primaryStage.close();
    }

}
