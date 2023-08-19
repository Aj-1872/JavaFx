package basic;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

    @FXML
    private Button clickButton; // Button to trigger actions

    private boolean buttonClicked = false; // Flag to track button click

    @FXML
    private void initialize() {
        // Define behavior when the button is clicked
        clickButton.setOnAction(event -> {
            if (!buttonClicked) {
                clickButton.setText("Button Clicked!");
                buttonClicked = true;

                // Open a new page after button click
                openNewPage();
            }
        });
    }

    // Method to open a new page based on user's choice
    private void openNewPage() {
        Alert.AlertType alertType = Alert.AlertType.INFORMATION; // Type of the confirmation alert
        String alertContentText = "Thank you for confirming, please click exit to close all the windows.";

        // Create a confirmation alert to decide whether to continue or not
        Alert chooseAlert = new Alert(Alert.AlertType.CONFIRMATION);
        chooseAlert.setTitle("User Confirmation Box");
        chooseAlert.setContentText("Do you want to continue?");

        // Define button types for the confirmation alert
        ButtonType yesButtonType = new ButtonType("yes");
        ButtonType noButtonType = new ButtonType("no");

        chooseAlert.getButtonTypes().setAll(yesButtonType, noButtonType);

        chooseAlert.showAndWait().ifPresent(buttonType -> {
            if (buttonType == yesButtonType) {

                try {
                    // Load the new page FXML
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("PokemonList.fxml"));
                    AnchorPane newPageRoot = loader.load();

                    // Create a new stage for the new page
                    Stage newStage = new Stage();
                    newStage.setTitle("List of most famous Pokemon");

                    // Set the new scene with the new page content
                    Scene newScene = new Scene(newPageRoot, 600, 400);
                    newStage.setScene(newScene);

                    // Show the new stage
                    newStage.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else if (buttonType == noButtonType) {

                // Show an information alert on choosing not to continue
                Alert alert = new Alert(alertType);
                alert.setTitle("Exit All Windows");
                alert.setContentText(alertContentText);
                ButtonType exitButton = new ButtonType("exit");
                alert.getButtonTypes().set(0, exitButton);

                // Define behavior on clicking the exit button in the alert
                alert.showAndWait().ifPresent(click -> {
                    if (click == exitButton) {
                        Platform.exit(); // Close all windows and exit the application
                    }
                });

            }

        });

    }
}
