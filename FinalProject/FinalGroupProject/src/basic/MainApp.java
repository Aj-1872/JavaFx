package basic;

import javafx.application.Application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private BackgroundMusicModel musicModel; // The model to manage background music

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the main FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Home.fxml"));
        Parent root = loader.load();

        // Initialize the background music model and start playing music
        musicModel = new BackgroundMusicModel();
        musicModel.playMusic();

        // Create the main scene
        Scene scene = new Scene(root, 600, 400);
        scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

        // Configure the primary stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Pokemon Application");
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(400);
        primaryStage.setMaxWidth(600);
        primaryStage.setMaxHeight(400);

        // Set a listener to stop music when the application is closed
        primaryStage.setOnCloseRequest(event -> {
            if (musicModel != null) {
                musicModel.stopMusic();
            }
        });

        // Display the primary stage
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
