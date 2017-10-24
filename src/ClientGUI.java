import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        setup(primaryStage);
    }

    private void setup(Stage primaryStage) {
        primaryStage.setTitle("Login");
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
        createForm(primaryStage);
        primaryStage.show();
    }

    private void createForm(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);
    }
}
