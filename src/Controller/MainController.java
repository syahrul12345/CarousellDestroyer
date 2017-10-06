package Controller;

import Model.Categories;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Arrays;


public class MainController {
    @FXML
    private TextField userField;
    @FXML
    private PasswordField passField;
    @FXML
    private ComboBox menuList;
    @FXML
    private TextArea console;

    public void testLogin(ActionEvent actionEvent) throws InterruptedException {
        String username = userField.getText();
        String password = passField.getText();



    }

}
