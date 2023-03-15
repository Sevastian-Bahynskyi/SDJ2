package com.example.lesson8_ex3.view;

import com.example.lesson8_ex3.view_model.ConvertViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ConvertViewController
{
    private ConvertViewModel viewModel;
    private ViewHandler viewHandler;
    private Region root;
    @FXML
    private TextField requestField;
    @FXML
    private TextField replyField;

    @FXML
    private Label errorLabel;


    public void init(ViewHandler viewHandler, ConvertViewModel viewModel, Region root)
    {
        this.viewModel = viewModel;
        this.viewHandler = viewHandler;
        this.root = root;
        viewModel.bindRequest(requestField.textProperty());
        viewModel.bindReply(replyField.textProperty());
        viewModel.bindError(errorLabel.textProperty());
    }

    public Region getRoot()
    {
        return root;
    }

    @FXML
    public void onSubmit()
    {
        viewModel.convert();
    }

    @FXML
    public void onEnter()
    {
        viewModel.convert();
    }

//    @Override
//    public void propertyChange(PropertyChangeEvent evt)
//    {
//        viewHandler.openView(ViewFactory.CONVERT);
//    }
}
