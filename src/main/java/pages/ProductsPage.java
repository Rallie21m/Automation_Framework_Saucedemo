package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

public class ProductsPage {
    protected WebDriver driver;
    private static final String ADD_TO_CART_LOCATOR = "//button[@id='add-to-cart-sauce-labs-%s']";

    @FindBy (className = "shopping_cart_link")
    private WebElement shoppingCartLink;

    @FindBy (className = "shopping_cart_badge")
    private WebElement shoppingCartCounter;

    @FindBy (id = "react-burger-menu-btn")
    private WebElement userAllPagesBtn;

    @FindBy (xpath = "//img[@src ='/static/media/bike-light-1200x1500.a0c9caae.jpg']")
    private WebElement imgItem0;

    @FindBy (xpath = "//img[@src ='/static/media/bolt-shirt-1200x1500.c0dae290.jpg']")
    private WebElement imgItem1;

    @FindBy (xpath = "//img[@src ='/static/media/red-onesie-1200x1500.1b15e1fa.jpg']")
    private WebElement imgItem2;

    @FindBy (xpath = "//img[@src ='/static/media/red-tatt-1200x1500.e32b4ef9.jpg']")
    private WebElement imgItem3;

    @FindBy (xpath = "//img[@src ='/static/media/sauce-backpack-1200x1500.34e7aa42.jpg']")
    private WebElement imgItem4;

    @FindBy (xpath = "//img[@src ='/static/media/sauce-pullover-1200x1500.439fc934.jpg']")
    private WebElement imgItem5;

    public ProductsPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isUserAllPagesBtnShown() {
        return userAllPagesBtn.isDisplayed();
    }
    public void addItemToTheCart (String productName){
        String xpathOfElementToBeAdded = String.format(ADD_TO_CART_LOCATOR, productName);
        WebElement addToCartButton = driver.findElement(By.xpath(xpathOfElementToBeAdded));
        addToCartButton.click();
    }
    public int getItemInTheCart(){
      return Integer.parseInt(shoppingCartCounter.getText());
    }

    public CartPage shoppingCart (){
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));
        fluentWait.until(ExpectedConditions.elementToBeClickable(shoppingCartLink));
        shoppingCartLink.click();
        return new CartPage(driver);
    }

    public boolean isCorrectImgDisplayed(){
        if(imgItem0.isDisplayed() && imgItem1.isDisplayed() && imgItem2.isDisplayed()
                && imgItem3.isDisplayed() && imgItem4.isDisplayed() && imgItem5.isDisplayed()) {
            return true;
        } else {return false;}
    }
}

