package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    protected WebDriver driver;
    private static final String REMOVE_FROM_CART_LOCATOR = "//button[@id='remove-sauce-labs-%s']";

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShoppingBtn;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutBtn;

    public CartPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isCheckoutBtnShown() {
        return checkoutBtn.isDisplayed();
    }

    public boolean isItemInTheCart (String productName) {
        String xpathOfElementToBeAdded = String.format(REMOVE_FROM_CART_LOCATOR, productName);
        WebElement itemInTheCart = driver.findElement(By.xpath(xpathOfElementToBeAdded));
        try {
            driver.findElement(By.xpath(xpathOfElementToBeAdded));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public CheckoutInfoPage checkout (){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn));
        checkoutBtn.click();
        return new CheckoutInfoPage (driver);
    }
}
