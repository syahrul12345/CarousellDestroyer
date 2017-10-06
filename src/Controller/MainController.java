package Controller;

import Model.LoginModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.*;


public class MainController {
    @FXML
    private TextField userField;
    @FXML
    private PasswordField passField;
    @FXML
    private ComboBox menuList;
    @FXML
    private TextArea console;
    private ExecutorService executorService = Executors.newFixedThreadPool(2);
    private LoginObserver loginObserver;
    private LoginModel loginModel;

    public void testLogin(ActionEvent actionEvent) throws InterruptedException, ExecutionException {
        String login = userField.getText();
        String password = passField.getText();
        console.appendText("Attempting login...." +"\n");
        loginModel = new LoginModel(null,login,password);
        loginObserver = new LoginObserver();
        loginModel.addObserver(loginObserver);
        Future future = executorService.submit(loginModel);

    }
    class LoginObserver implements Observer {

        @Override
        public void update(Observable o, Object arg) {
            Boolean loginFlag = loginModel.getLoginFlag();
            if(loginFlag = true) {
                console.appendText("Login succesfull");
            } else {
                console.appendText("Login failed, please check your credentials");
            }
        }
    }

}

