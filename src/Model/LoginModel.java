package Model;

import com.anti_captcha.AnticaptchaBase;
import javafx.collections.ObservableList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import java.util.Observable;
import java.util.concurrent.Callable;

public class LoginModel extends Observable implements Callable {
    private Boolean loginFlag;
    private String user;
    private String password;

    public LoginModel(Boolean loginFlag, String user, String password) {
        this.loginFlag = loginFlag;
        this.user = user;
        this.password = password;

    }

    @Override
    public Object call() throws Exception {

        //fills up the login info

        HtmlUnitDriver htmlUnitDriver = new HtmlUnitDriver();
        htmlUnitDriver.get("https://sg.carousell.com/login/");
        htmlUnitDriver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys(user);
        htmlUnitDriver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);




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
