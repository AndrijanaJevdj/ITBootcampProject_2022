package demoBlaze.com.PagesDemoBlaze;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
    private WebDriver webDriver;

    @FindBy (css = "#login2")
    WebElement logInLink;

    @FindBy (id = "loginusername")
    WebElement logInUsername;

    @FindBy (id = "loginpassword")
    WebElement logInPassword;

    @FindBy (xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[3]/button[2]")
    WebElement logInButton;

    @FindBy (linkText = "Log out")
    WebElement logOutButton;


    public Login(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void OpenLogIn(){
        logInLink.click();
    }

    public void InputLogInUsername(){
        logInUsername.sendKeys("Anaa");
    }

    public void InputLogInPassword(){
        logInPassword.sendKeys("kljuc");
    }

    public void ClickOnLogIn(){
        logInButton.click();
    }

    public void InputLogInWrongPassword(){
        logInPassword.sendKeys("kluc");
    }

    public void InputLogInWrongUsername(){
        logInUsername.sendKeys("Hana");
    }

    public void ClickOnLogOut(){
        logOutButton.click();
    }
}

