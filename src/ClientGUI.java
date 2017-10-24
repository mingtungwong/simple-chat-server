import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientGUI extends Application {

    private static ArrayList<Message> messages = new ArrayList<Message>();
    private static ArrayList<User> users = new ArrayList<User>();
    private static Socket client;
    private static ObjectOutputStream out;
    private static ObjectInputStream in;
    private static Stage primaryStage;
    private static String user;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage pStage) {
        primaryStage = pStage;
        setupConnection();
        setup();
        createScene();
        primaryStage.show();
    }

    private void setupConnection() {
        Thread connection = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    client = new Socket("127.0.0.1", 5555);
                    out = new ObjectOutputStream(client.getOutputStream());
                    in = new ObjectInputStream(client.getInputStream());
                    Request r = (Request)in.readObject();
                    handleResponse(r);
                } catch(Exception e) {
                    new Alert(Alert.AlertType.ERROR, e.getMessage());
                }
            }
        });
        connection.start();
    }

    private void setup() {
        primaryStage.setTitle("Login");
        primaryStage.setWidth(300);
        primaryStage.setHeight(300);
    }

    private void createScene() {
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
                user = userText.getText();
                try {
                    out.writeObject(new Request(Request.Requests.ADDUSER, user));
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }

                //Alert alert = new Alert(Alert.AlertType.ERROR, "The Username is already in use. Please choose another one\nand try again.");
                //alert.showAndWait();
            }
        });
    }

    private static void handleResponse(Request rq) {
        Request.Requests type = rq.getRequestType();
        switch(type) {
            case ADDUSER:
                createMainView();
        }
    }

    private static void createMainView() {
        System.out.println("I'm here");
    }
}
