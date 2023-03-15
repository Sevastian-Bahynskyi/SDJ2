package com.example.lesson8_ex4.view;

import com.example.lesson8_ex4.view_model.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

public class ViewFactory {
    public static final String CREATE = "create";
    public static final String MESSAGE = "message";
    public static final String GOODBYE = "goodbye";

    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;

    private CreateAccountViewController createAccountViewController;
    private MessageViewController messageViewController;
    private GoodbyeViewController goodbyeViewController;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.createAccountViewController = null;
        this.messageViewController = null;
    }

    public Region loadCreateAccountView() {
        if (createAccountViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("CreateAccountView.fxml"));
            try {
                Region root = loader.load();
                createAccountViewController = loader.getController();
                createAccountViewController.init(viewHandler, viewModelFactory.getCreateAccountViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        viewModelFactory.getCreateAccountViewModel().reset();
        return createAccountViewController.getRoot();
    }

    public Region loadMessageView() {
        if (messageViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("MessageView.fxml"));
            try {
                Region root = loader.load();
                messageViewController = loader.getController();
                messageViewController.init(viewHandler, viewModelFactory.getMessageViewModel(), root);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return messageViewController.getRoot();
    }

    public Region load(String id) {
        return switch (id) {
            case CREATE -> loadCreateAccountView();
            case MESSAGE -> loadMessageView();
            case GOODBYE -> loadGoodbyeView();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
    }

    private Region loadGoodbyeView()
    {
        if (goodbyeViewController == null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("GoodbyeView.fxml"));
            try {
                Region root = loader.load();
                goodbyeViewController = loader.getController();
                goodbyeViewController.init(viewHandler, viewModelFactory.getGoodbyeViewModel(), root);
                Region temp = loadMessageView();
                double width = temp.getWidth();
                double height = temp.getHeight();
                goodbyeViewController.getRoot().setPrefWidth(width);
                goodbyeViewController.getRoot().setPrefHeight(height);
            } catch (IOException e) {
                throw new IOError(e);
            }
        }
        return goodbyeViewController.getRoot();
    }
}
