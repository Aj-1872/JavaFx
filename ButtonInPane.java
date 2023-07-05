import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ButtonInPane extends Application {

    @Override
    public void start(Stage primaryStage) {
        HBox hbox = new HBox(); // Use HBox instead of StackPane
        hbox.getChildren().addAll(new Button("Ok"), new Button("first program"));

        Scene scene = new Scene(hbox, 200, 250);
        primaryStage.setTitle("Button in a Pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
