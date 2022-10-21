package demoBlaze.com.TestsDemoBlaze;
import demoBlaze.com.PagesDemoBlaze.Login;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.AssertJUnit.assertTrue;

public class TestLogin {
    private WebDriver webDriver;
    private Login login;


    @BeforeMethod
    public void setUp() {
         WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        login = new Login(webDriver);
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        //   webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
        webDriver.get("https://www.demoblaze.com/");
        webDriver.manage().window().maximize();

    }

    // region Successful login to the site
    @Test
    public void LogInTest() throws InterruptedException {
        login.OpenLogIn();
        login.InputLogInUsername();
        login.InputLogInPassword();
        login.ClickOnLogIn();
        webDriver.switchTo().alert().accept();
    }
    //endregion

    //region Wrong password
    @Test
    public void WrongPasswordLogIn() throws InterruptedException {
        login.OpenLogIn();
        login.InputLogInUsername();
        login.InputLogInWrongPassword();
        login.ClickOnLogIn();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        Thread.sleep(1000);
        Alert alert = webDriver.switchTo().alert();
        System.out.println(alert.getText());
        Assert.assertTrue(alert.getText().contains("Wrong password."));
        alert.accept();


    }
    //endregion

    // region Successful logout
    @Test
    public void LogOut(){
        login.OpenLogIn();
        login.InputLogInUsername();
        login.InputLogInPassword();
        login.ClickOnLogIn();
        login.ClickOnLogOut();

    }

    //endregion

    //region Close web driver
    @AfterTest
    public void closeWebDriver() {
        webDriver.close();
    }
    //endregion
}
