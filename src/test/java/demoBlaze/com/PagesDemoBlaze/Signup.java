package demoBlaze.com.PagesDemoBlaze;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Signup {

    private WebDriver webDriver;
    private WebDriverWait wait;

    @FindBy (id = "signin2")
    WebElement SignUp;

    @FindBy (id = "sign-username")
    WebElement username;

    @FindBy (id ="sign-password")
    WebElement password;

    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/button[2]")
    WebElement signUpButton;

    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[3]/button[1]")
    WebElement closeButton;

    @FindBy (xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/div[1]/button[1]/span[1]")
    WebElement exitButton;


    public Signup(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void OpenSignUp(){
        SignUp.click();
    }
    public void InputUsername(){
        username.sendKeys("Onaaa");
    }
    public void InputPassword(){
        password.sendKeys("nnaa");
    }
    public void ClickOnSignUp(){
        signUpButton.click();
    }
    public void ClickOnClose(){
        closeButton.click();
    }
    public void ClickOnExit(){
        exitButton.click();
    }

    public WebElement getUsername() {
        return username;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getSignUpButton() {
        return signUpButton;
    }

    public WebElement getCloseButton() {
        return closeButton;
    }

    public WebElement getExitButton() {
        return exitButton;
    }
}
