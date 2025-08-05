package tests;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pages.UserManagementPage;

public class UserManagementTest extends BaseTest {
    @Test
    public void addFormUM() throws InterruptedException {
        UserManagementPage page =new UserManagementPage(driver,this);
        LoginTest login =new LoginTest();
        login.validTestLogin();
        Thread.sleep(1000);
        page.clickUM();
        page.clickAddUser();
        page.enterName();
        page.enterEmail();
        page.enterUserName();
        page.selectGender();Thread.sleep(1000);
        page.contactNumber();
        page.selectRole();
        page.selectUserType();
        page.selectUnit();
        page.enterPassword();
        page.smtBtn();

    }

}
