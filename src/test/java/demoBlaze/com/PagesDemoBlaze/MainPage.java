package demoBlaze.com.PagesDemoBlaze;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    private WebDriver webDriver;

    @FindBy (xpath = "/html[1]/body[1]/nav[1]/div[1]/ul[1]/li[1]/a[1]")
    WebElement home;

    @FindBy (xpath = "/html[1]/body[1]/div[5]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/h4[1]/a[1]")
    WebElement phone;

    @FindBy (xpath = "/html[1]/body[1]/div[5]/div[1]/div[2]/div[2]/div[1]/a[1]")
    WebElement addToCart;

    @FindBy (xpath = "/html[1]/body[1]/nav[1]/div[1]/ul[1]/li[2]/a[1]")
    WebElement contactUs;

    @FindBy (xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")
    WebElement contactEmail;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]")
    WebElement contactName;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/form[1]/div[3]/textarea[1]")
    WebElement contactMessage;

    @FindBy(xpath = "/html[1]/body[1]/div[1]/div[1]/div[1]/div[3]/button[2]")
    WebElement sendMessage;

    @FindBy(xpath = "/html[1]/body[1]/nav[1]/div[1]/ul[1]/li[3]/a[1]")
    WebElement openAboutUs;

    @FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/button[1]")
    WebElement playVideo;

    @FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[4]/button[1]")
    WebElement pause;

    @FindBy(xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[4]/button[1]/span[2]")
    WebElement play;

    @FindBy (xpath = "/html[1]/body[1]/div[4]/div[1]/div[1]/div[3]/button[1]")
    WebElement closeAboutUsButton;

    @FindBy (xpath = "/html[1]/body[1]/nav[1]/a[1]")
    WebElement logoButton;

    @FindBy (xpath = "/html[1]/body[1]/nav[1]/div[2]/div[1]/a[1]")
    WebElement rightButtonForSlidePictures;

    @FindBy(xpath = "/html[1]/body[1]/nav[1]/div[2]/div[1]/a[2]")
    WebElement leftButtonForSlidePictures;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public MainPage(WebElement clickOnPhone) {
        this.phone = clickOnPhone;
    }
    public void moveToPhone() throws InterruptedException {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", phone);
    }
    public void OpenPhone(){
        phone.click();
    }
    public void ClickAddToCart() throws InterruptedException {
        addToCart.click();
    }
    public void ClickOnHome(){
        home.click();
    }
    public void OpenContactUs(){
        contactUs.click();
    }
    public void InputContactEmail(){
        contactEmail.sendKeys("Anaa");
    }
    public void InputContactName(){
        contactName.sendKeys("Ana");
    }

    public void InputContactMessage(){
        contactMessage.sendKeys("blablablabla");
    }

    public void ClickSendMessage(){
        sendMessage.click();
    }

    public  void OpenAboutUs(){
        openAboutUs.click();
    }
    public void PlayVideo(){
        playVideo.click();
    }
    public void PauseVideo(){
        pause.click();
    }
    public void CloseAboutUs(){
        closeAboutUsButton.click();
    }
    public void LogoButton(){
        logoButton.click();
    }

    public void ClickOnRightButtonForSlidePictures(){
        rightButtonForSlidePictures.click();
    }
    public void ClickOnLeftButtonForSlidePictures(){
        leftButtonForSlidePictures.click();
    }


    //region Getters
    public WebElement getHome() {
        return home;
    }

    public WebElement getPhone() {
        return phone;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

    public WebElement getContactUs() {
        return contactUs;
    }

    public WebElement getContactEmail() {
        return contactEmail;
    }

    public WebElement getContactName() {
        return contactName;
    }

    public WebElement getContactMessage() {
        return contactMessage;
    }

    public WebElement getSendMessage() {
        return sendMessage;
    }

    public WebElement getOpenAboutUs() {
        return openAboutUs;
    }

    public WebElement getPlayVideo() {
        return playVideo;
    }

    public WebElement getPause() {
        return pause;
    }

    public WebElement getPlay() {
        return play;
    }

    public WebElement getCloseAboutUsButton() {
        return closeAboutUsButton;
    }

    public WebElement getLogoButton() {
        return logoButton;
    }

    public WebElement getRightButtonForSlidePictures() {
        return rightButtonForSlidePictures;
    }

    public WebElement getLeftButtonForSlidePictures() {
        return leftButtonForSlidePictures;
    }
    //endregion
}
