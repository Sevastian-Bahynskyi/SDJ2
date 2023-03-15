package dk.via.mvvm.view;


import dk.via.mvvm.model.UserModelManager;
import dk.via.mvvm.viewmodel.CreateAccountViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CreateAccountViewController implements PropertyChangeListener
{
    @FXML private TextField username;
    @FXML private TextField password;
    @FXML private TextField email;
    @FXML private Label errorLabel;
    private ViewHandler viewHandler;
    private CreateAccountViewModel viewModel;
    private Region root;

    @FXML
    protected void createButtonPressed() {
        viewModel.createUser();
    }

    @FXML
    protected void cancelButtonPressed() {
        viewHandler.closeView();
    }

    @FXML
    public void submitUsername() {
        password.requestFocus();
    }

    @FXML
    public void submitPassword() {
        email.requestFocus();
    }

    @FXML
    public void submitEmail() {
        createButtonPressed();
    }

    public void init(ViewHandler viewHandler, CreateAccountViewModel createAccountViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = createAccountViewModel;
        this.root = root;

        createAccountViewModel.bindUsername(username.textProperty());
        createAccountViewModel.bindPassword(password.textProperty());
        createAccountViewModel.bindEmail(email.textProperty());
        createAccountViewModel.bindError(errorLabel.textProperty());
        viewModel.addPropertyChangeListener("last user", this);
    }

    public Region getRoot() {
        return root;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt)
    {
        viewHandler.openView(ViewFactory.MESSAGE);
    }
}