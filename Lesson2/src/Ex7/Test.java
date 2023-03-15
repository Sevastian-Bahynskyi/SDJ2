package Ex7;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Random;

public class Test extends Application {

    private int dice1;
    private int dice2;
    private Label dice1Label = new Label();
    private Label dice2Label = new Label();
    private Label resultLabel = new Label();

    @Override
    public void start(Stage primaryStage) {
        Button rollButton = new Button("Roll");
        rollButton.setOnAction(event -> rollDice());

        HBox diceBox = new HBox(dice1Label, dice2Label);
        diceBox.setSpacing(10);
        diceBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(diceBox, rollButton, resultLabel);
        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Dice Roller");
        primaryStage.show();
    }

    private void rollDice() {
        Random random = new Random();
        dice1 = random.nextInt(6) + 1;
        dice2 = random.nextInt(6) + 1;

        dice1Label.setText(String.valueOf(dice1));
        dice2Label.setText(String.valueOf(dice2));

        int sum = dice1 + dice2;
        if (sum == 7) {
            resultLabel.setText("You won!");
        } else {
            resultLabel.setText("Try again");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

