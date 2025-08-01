package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardPage {


    public DashBoardPage() {

    }
    @FindBy(xpath = "//input[@type=\"email\"]")
    private WebElement emailField;
}
