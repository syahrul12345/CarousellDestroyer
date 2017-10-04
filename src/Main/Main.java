package Main;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/FXML/sample.fxml"));
        primaryStage.setTitle("CarousellBot");
        primaryStage.setScene(new Scene(root, 700, 300));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
