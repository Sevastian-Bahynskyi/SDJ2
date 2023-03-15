package dk.via.mvvm.view;

import dk.via.mvvm.viewmodel.GoodbyeViewModel;
import dk.via.mvvm.viewmodel.MessageViewModel;
import dk.via.mvvm.viewmodel.ViewModelFactory;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import javafx.scene.text.Font;

import java.io.ByteArrayOutputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.*;


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
