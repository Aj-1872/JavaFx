
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Img extends Application {

    @Override
    public void start(Stage primaryStage) {
        Image img = new Image("th.png");

        ImageView imgView = new ImageView(img);
        imgView.setX(100);
        imgView.setY(100);
        imgView.setFitHeight(200);
        imgView.setFitWidth(400);
        imgView.setPreserveRatio(true);

        Pane pane = new Pane();
        pane.getChildren().add(imgView);

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show Image");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
