import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ClientGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        setup(primaryStage);
        createScene(primaryStage);
        primaryStage.show();
    }

    private void setup(Stage primaryStage) {
        primaryStage.setTitle("Login");
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
    }

    private void createScene(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        Scene scene = new Scene(grid, 300, 300);
        primaryStage.setScene(scene);
        createForm(grid);
    }

    private void createForm(GridPane grid) {
        Text label = new Text("Welcome");
        label.setFont(Font.font("Consolas", FontWeight.NORMAL, 20));
        grid.add(label, 0, 0, 2, 1);

        Label username = new Label("Username:");
        grid.add(username, 0, 1);

        TextField userText = new TextField();
        grid.add(userText, 1, 1);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println(userText.getText());
            }
        });
    }
}
