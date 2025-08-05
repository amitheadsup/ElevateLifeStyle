package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;


    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement emailField;

    @FindBy(id = "password")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@type=\"submit\"]")
    private WebElement loginButton;

    @FindBy(xpath = "//a[contains(text(), 'Forgot Password')]")
    private WebElement forgotPasswordLink;

    @FindBy(xpath = "//*[contains(@class, 'error') or contains(@class, 'alert')]")
    private WebElement errorMessage;

    @FindBy(xpath = "//*[contains(text(), 'Remember me')]")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//span[@class=\"font-medium text-sm\"]")
    public WebElement invalidLoginErrorMessage;

    @FindBy(xpath = "//p[text()='Email is required']")
    public WebElement emailRequiredError;

    @FindBy(xpath = "//p[text()='Password is required']")
    public WebElement passwordRequiredError;



    public String enterEmail(String email) {
//        emailField.clear();
        System.out.println("entering email" + email);
        emailField.sendKeys(email);
        return email;
    }

    public void enterPassword(String password) {
//        emailField.clear();
        passwordField.sendKeys(password);

    }

    public void clickLoginButton() {
        //emailField.clear();
        loginButton.click();
        System.out.println("clicking login button");


    }

    public void clickForgotPasswordLink() {
        //emailField.clear();
        forgotPasswordLink.click();

    }

    public String getInvalidLoginErrorMessage() {
        return invalidLoginErrorMessage.getText();
    }

    public void selectRememberBox() {
        if (rememberMeCheckbox.isSelected()) {
            rememberMeCheckbox.click();
        }


    }
}
