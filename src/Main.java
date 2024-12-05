import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;



public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        Label label = new Label("Welcome to JavaFX!");
        Button btn = new Button("Say Hello");
        btn.setOnAction(e -> label.setText("Hello, JavaFX!"));
        VBox vbox = new VBox(10, label, btn); // VBox with 10px spacing
        Scene scene = new Scene(vbox, 300, 250);

        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        primaryStage.setTitle("JavaFX Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}