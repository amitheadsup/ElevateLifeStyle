package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    //LoginPage validlogin=new LoginPage(driver);
    LoginPage validlogin = new LoginPage(driver);
    @Test
    public void validTestLogin() {

        String email = config.getAdminUsername();
        String password = config.getAdminPassword();
        validlogin.enterEmail(email);
        validlogin.enterPassword(password);
        validlogin.clickLoginButton();
    }
    public void invalidPassword(){
        validlogin.enterPassword(config.getAdminPassword());

    }


}
