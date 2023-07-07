import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class FXMLExample extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Create a GridPane as the root node
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10); // Set horizontal gap
        gridPane.setVgap(10); // Set vertical gap

        // Create row constraints for the three rows
        RowConstraints row1 = new RowConstraints();
        RowConstraints row2 = new RowConstraints();
        RowConstraints row3 = new RowConstraints();
        gridPane.getRowConstraints().addAll(row1, row2, row3);

        // Create column constraints for the two columns
        ColumnConstraints col1 = new ColumnConstraints();
        ColumnConstraints col2 = new ColumnConstraints();
        gridPane.getColumnConstraints().addAll(col1, col2);

        // Create labels and add them to the grid
        Label welcomeLabel = new Label("Welcome");
        Label usernameLabel = new Label("User Name:");
        Label passwordLabel = new Label("Password");

        gridPane.add(welcomeLabel, 0, 0);
        gridPane.add(usernameLabel, 0, 1);
        gridPane.add(passwordLabel, 0, 2);

        Scene scene = new Scene(gridPane, 300, 275);
        primaryStage.setTitle("FXML WELCOME");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
