package com.example.lesson8_ex4.view;

import com.example.lesson8_ex4.view_model.GoodbyeViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;


public class GoodbyeViewController
{
    private ViewHandler viewHandler;
    private GoodbyeViewModel goodbyeViewModel;
    private Region root;
    @FXML
    private Label emoji;

    public void init(ViewHandler viewHandler, GoodbyeViewModel viewModel, Region root)
    {
        this.viewHandler = viewHandler;
        this.root = root;
        this.goodbyeViewModel = viewModel;

        viewModel.bindUserNumber(emoji.textProperty());
    }


    public Region getRoot()
    {
        return root;
    }

}
