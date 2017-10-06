package Model;

import javafx.collections.ObservableList;
import org.openqa.selenium.By;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.Observable;
import java.util.concurrent.Callable;

public class LoginModel extends Observable implements Callable {
    private Boolean loginFlag;

    public LoginModel(Boolean loginFlag) {
        this.loginFlag = loginFlag;
    }

    @Override
    public Object call() throws Exception {

        HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver();
        htmlUnitDriver.get("https://sg.carousell.com/login/");

        if(htmlUnitDriver.getTitle().contains("Login")) {
            loginFlag = true;
        } else {
            loginFlag = false;
        }
        setChanged();
        notifyObservers();
        return loginFlag;

    }

    public Boolean getLoginFlag() {
        return loginFlag;
    }
}
