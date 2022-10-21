package demoBlaze.com.PagesDemoBlaze;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart {

    private WebDriver webDriver;

    @FindBy (xpath = "/html[1]/body[1]/nav[1]/div[1]/ul[1]/li[4]/a[1]")
    WebElement openCart;
    @FindBy(xpath = "/html[1]/body[1]/nav[1]/div[1]/div[1]/ul[1]/li[4]/a[1]")
    WebElement cart2;
    @FindBy (xpath = "/html[1]/body[1]/div[6]/div[1]/div[2]/div[1]/div[1]/h3[1]")
    WebElement totalP;
    @FindBy (xpath = "/html[1]/body[1]/div[6]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/td[3]")
    WebElement price;
    @FindBy (xpath ="/html[1]/body[1]/div[6]/div[1]/div[2]/button[1]" )
    WebElement placeOrder;
    @FindBy (xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[1]/input[1]")
    WebElement name;
    @FindBy (xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[2]/input[1]")
    WebElement country;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[3]/input[1]")
    WebElement city;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[4]/input[1]")
    WebElement creditCard;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[5]/input[1]")
    WebElement month;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[2]/form[1]/div[6]/input[1]")
    WebElement year;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[3]/button[2]")
    WebElement purchase;

    @FindBy(xpath = "/html[1]/body[1]/div[3]/div[1]/div[1]/div[3]/button[1]")
    WebElement close;


    public Cart(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this);
    }

    public void OpenCart(){
        openCart.click();
    }
    public void NameEntry(){
        name.sendKeys("Maja");
    }
    public void CountryEntry(){
        country.sendKeys("Serbia");
    }
    public void CityEntry(){
        city.sendKeys("Belgrade");
    }
    public void CreditCardEntry(){
        creditCard.sendKeys("12345");
    }
    public void MonthEntry(){
        month.sendKeys("June");
    }
    public void YearEntry(){
        year.sendKeys("1999");
    }
    public void ClickOnPurchase(){
        purchase.click();
    }
    public void ClickOnCLose(){
        close.click();
    }
    public void PriceVisible(){
        price.isDisplayed();
    }
    public void TotalPriceVisible(){
        totalP.isDisplayed();
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    public WebElement getTotalP() {
        return totalP;
    }

    public WebElement getPrice() {
        return price;
    }

    public void OpenCart2(){
        cart2.click();
    }

    //region Getters
    public WebElement getOpenCart() {
        return openCart;
    }

    public WebElement getCart2() {
        return cart2;
    }

    public WebElement getPlaceOrder() {
        return placeOrder;
    }

    public WebElement getName() {
        return name;
    }

    public WebElement getCountry() {
        return country;
    }

    public WebElement getCity() {
        return city;
    }

    public WebElement getCreditCard() {
        return creditCard;
    }

    public WebElement getMonth() {
        return month;
    }

    public WebElement getYear() {
        return year;
    }

    public WebElement getPurchase() {
        return purchase;
    }

    public WebElement getClose() {
        return close;
    }
    //endregion
}

