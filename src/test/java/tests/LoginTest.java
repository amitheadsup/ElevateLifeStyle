package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {
    //LoginPage validlogin=new LoginPage(driver);

    @Test
    public void validTestLogin() {
        LoginPage validLogin = new LoginPage(driver);
        String email = config.getAdminUsername();
        String password = config.getAdminPassword();
        validLogin.enterEmail(email);
        validLogin.enterPassword(password);
        validLogin.clickLoginButton();
    }

    @Test
    public void invalidEmailTest() {
        LoginPage validLogin = new LoginPage(driver);
        validLogin.enterEmail(config.getInvalidUsername());
        validLogin.enterPassword(config.getAdminPassword());
        validLogin.clickLoginButton();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"font-medium text-sm\"]")));
        String expectedMessage = "Invalid credentials";
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch!");      //verify the error message
    }

    @Test
    public void invalidPasswordTest() {
        LoginPage validLogin = new LoginPage(driver);
        validLogin.enterEmail(config.getAdminUsername());
        validLogin.enterPassword(config.getInvalidPassword());
        validLogin.clickLoginButton();
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOf(validLogin.invalidLoginErrorMessage));
        String expectedMessage = "Invalid credentials";
        String actualMessage = errorMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage, "Error message mismatch!");
        System.out.println(actualMessage);

    }

    @Test
    public void blankEmailAndPassword() {
        LoginPage validLogin = new LoginPage(driver);
        validLogin.enterEmail("");
        validLogin.enterPassword("");
        validLogin.clickLoginButton();
        WebElement emailError = wait.until(ExpectedConditions.visibilityOf(validLogin.emailRequiredError));
        WebElement passwordError = wait.until(ExpectedConditions.visibilityOf(validLogin.passwordRequiredError));

        String expectedEmailError = "Email is required";
        String expectedPasswordError = "Password is required";

        String actualEmailError = emailError.getText();
        String actualPasswordError = passwordError.getText();

        Assert.assertEquals(actualEmailError, expectedEmailError, "Email error message mismatch!");
        Assert.assertEquals(actualPasswordError, expectedPasswordError, "Password error message mismatch!");

        System.out.println("Email Error: " + actualEmailError);
        System.out.println("Password Error: " + actualPasswordError);

    }

}
