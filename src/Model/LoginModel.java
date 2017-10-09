package Model;

import Model.JSON.JSONCreate;
import Model.JSON.JSONmain;
import com.anti_captcha.Api.ImageToText;
import com.anti_captcha.Api.NoCaptchaProxyless;
import com.anti_captcha.Helper.DebugHelper;

import java.net.MalformedURLException;
import java.net.URL;
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
        //gets the soln

        // how to get the query string????
        String solution = AntiCaptcha();
        JSONCreate jsonCreate = new JSONCreate(user,password,solution);
        JSONmain jsonMain = jsonCreate.getJsonMain();
        //send jsonMain

        setChanged();
        notifyObservers();
        return loginFlag;
    }
    //solves the captcha and returns the hash
    private String AntiCaptcha() throws InterruptedException, MalformedURLException {
        DebugHelper.setVerboseMode(true);
        NoCaptchaProxyless api = new NoCaptchaProxyless();
        api.setClientKey("be43df9db92c4a3c381683be8db91e26");
        api.setWebsiteUrl(new URL("https://sg.carousell.com"));
        api.setWebsiteKey("6Lc-KiYTAAAAAGkGKh1LNFmCAlEGvhABCl4o56SE");

        if (!api.createTask()) {
            DebugHelper.out(
                    "API v2 send failed. " + api.getErrorMessage(),
                    DebugHelper.Type.ERROR
            );
        } else if (!api.waitForResult()) {
            DebugHelper.out("Could not solve the captcha.", DebugHelper.Type.ERROR);
        } else {
            DebugHelper.out("Result: " + api.getTaskSolution(), DebugHelper.Type.SUCCESS);
            return api.getTaskSolution();
        }
        return null;
    }
    private void GetBalance()
    {
        DebugHelper.setVerboseMode(true);

        ImageToText api = new ImageToText();
        api.setClientKey("be43df9db92c4a3c381683be8db91e26");

        Double balance = api.getBalance();

        if (balance == null)
        {
            DebugHelper.out("GetBalance() failed. " + api.getErrorMessage(), DebugHelper.Type.ERROR);
        }
        else
        {
            DebugHelper.out("Balance: " + balance, DebugHelper.Type.SUCCESS);
        }

    }

    public Boolean getLoginFlag() {
        return loginFlag;
    }
}
