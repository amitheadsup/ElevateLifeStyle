package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.UserManagementPage;

import java.time.Duration;

public class UserManagementTest extends BaseTest {
    @Test
    public void addFormUM() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.enterEmail(config.getAdminUsername());
        login.enterPassword(config.getAdminPassword());
        login.clickLoginButton();
        UserManagementPage page = new UserManagementPage(driver, this);
        Thread.sleep(1000);
        page.clickUM();
        page.clickAddUser();
        page.enterName();
        page.enterEmail();
        page.enterUserName();
        page.selectGender();
        Thread.sleep(1000);
        page.contactNumber();
        page.selectRole();
        page.selectUserType();
        page.selectUnit();
        page.enterPassword();
        page.smtBtn();

    }

    @Test
    public void updateFormUM() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.enterEmail(config.getAdminUsername());
        login.enterPassword(config.getAdminPassword());
        login.clickLoginButton();
        UserManagementPage page = new UserManagementPage(driver, this);
        Thread.sleep(1000);
        page.clickUM();
        Thread.sleep(1000);
        page.clickUpdateIcon();
        Thread.sleep(1000);
        WebElement phoneField = driver.findElement(By.xpath("//input[@id='phoneNumber']"));
        phoneField.clear();
        phoneField.sendKeys("9999999999");
        page.updateUserBtn();
        System.out.println("sojmmd");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement toastMessage = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'User updated successfully')]"))
        );

        String actualMessage = toastMessage.getText();
        System.out.println("Toast Message: " + actualMessage);
        Assert.assertEquals(actualMessage.trim(), "User updated successfully!");

    }
@Test
    public void deleteFormUM() throws InterruptedException {
        LoginPage login = new LoginPage(driver);
        login.enterEmail(config.getAdminUsername());
        login.enterPassword(config.getAdminPassword());
        login.clickLoginButton();
        UserManagementPage page = new UserManagementPage(driver, this);
        Thread.sleep(1000);
        page.clickUM();
        Thread.sleep(1000);
    System.out.println("log");
        page.deleteUserBtn();
    System.out.println("kodfnkj");

    }
}
