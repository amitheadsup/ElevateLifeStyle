package pages;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class UserManagementPage {

    WebDriver driver;
    BaseTest base;

    public UserManagementPage(WebDriver driver , BaseTest base) {
        this.driver = driver;
        this.base = base;
        PageFactory.initElements(driver, this);  //
    }

    @FindBy(xpath = "//span[normalize-space()='User Management']")
    private WebElement userManagementSideBar;

    @FindBy(xpath = "//button[normalize-space()='Add User']")
    private WebElement addUserbtn;

    @FindBy(xpath = "//input[@id=\"name\"]")
    private WebElement fullNameField;

    @FindBy(xpath = "//input[@id=\"email\"]")
    private WebElement emailField;

    @FindBy(xpath = "//input[@id=\"username\"]")
    private WebElement userName;

    @FindBy(xpath = "//select[@class='w-full h-11 py-2 bg-transparent border rounded-lg transition-colors border-slate-300 hover:border-slate-400 focus:border-blue-500 placeholder:text-slate-400 focus:outline-none focus:ring-1 focus:ring-blue-500/20 pl-3 pr-3 ']")
    private WebElement gender;  //xpath for gender Id= //*[text()='Select gender']

    @FindBy(xpath = "//input[@id=\"phoneNumber\"]")
    private WebElement phoneNumber;

    @FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement genderFemale;

    @FindBy(xpath = "//input[contains(@placeholder,'Select a role')]")
    private WebElement selectRole;

    @FindBy(xpath = "//input[@placeholder=\"Select a user type\"]")
    private WebElement selectUserType;

    @FindBy(xpath = "//*[text()=\"Select units\"]")
    private WebElement selectUnit;

    @FindBy(xpath = "//input[@id=\"password\"]")
    private WebElement password;

    @FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement profileURl;

    @FindBy(xpath = "//*[text()=\"Add User\"]")
    private WebElement addUserSubmitBtn;


    public void clickUM() {
        userManagementSideBar.click();
    }

    public void clickAddUser() {
        addUserbtn.click();
    }

    public void enterName() {
        fullNameField.sendKeys("Testing Purpose");
    }

    public void enterEmail() {
        emailField.sendKeys("Testing Purpose");
    }

    public void enterUserName() {
        userName.sendKeys("Testing Purpose");
    }

    public void selectGender() {
        Select genderDropDown = new Select(gender);
        genderDropDown.selectByVisibleText("Male");
        //gender.click();
    }

    public void selectRole() {
        Select roleDropDown = new Select(selectRole);
        roleDropDown.selectByVisibleText("Staff");
        selectRole.click();
    }

    public void selectUserType() {
        Select userTypeDropDown = new Select(selectUserType);
        userTypeDropDown.deselectByVisibleText("Manager");
    }

    public void selectUnit() {
        Select unitDropDown = new Select(selectUnit);
        unitDropDown.deselectByVisibleText("Elevate 2 (UNIT7692)");
    }

    public void enterPassword() {
        password.sendKeys("Amit@123");
    }

    public void contactNumber() {
        phoneNumber.sendKeys("1232323222");
        base.waitForPage();
    }

    public void smtBtn() {
        addUserSubmitBtn.click();
    }


}
