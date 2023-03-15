package dk.via.mvvm.view;

import dk.via.mvvm.viewmodel.MessageViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;

public class MessageViewController {
    @FXML public Label userCount;
    @FXML public Label userInfo;
    private ViewHandler viewHandler;
    private MessageViewModel messageViewModel;
    private Region root;

    @FXML
    public void okButtonPressed() {
        viewHandler.openView(ViewFactory.GOODBYE);
    }

    @FXML
    public void continueButtonPressed() {
        viewHandler.openView(ViewFactory.CREATE);
    }

    public void init(ViewHandler viewHandler, MessageViewModel messageViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.messageViewModel = messageViewModel;
        this.root = root;

        messageViewModel.bindUserNumber(userCount.textProperty());
        messageViewModel.bindUserInfo(userInfo.textProperty());
    }

    public Region getRoot() {
        return root;
    }
}
