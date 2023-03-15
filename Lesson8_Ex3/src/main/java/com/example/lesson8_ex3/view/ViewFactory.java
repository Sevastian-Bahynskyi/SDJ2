package com.example.lesson8_ex3.view;

import com.example.lesson8_ex3.view_model.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOException;

public class ViewFactory
{
    public static final String CONVERT = "convert";
    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private ConvertViewController convertViewController;
    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
    {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
    }

    public Region loadConvertView()
    {
        if (convertViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("ConvertView.fxml"));
            try {
                Region root = loader.load();
                convertViewController = loader.getController();
                convertViewController.init(viewHandler, viewModelFactory.getConvertViewModel(), root);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return convertViewController.getRoot();
    }

    public Region load(String id)
    {
        return switch (id)
        {
            case CONVERT -> loadConvertView();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
    }

}
