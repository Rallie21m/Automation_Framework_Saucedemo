package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutInfoPage {
    protected WebDriver driver;

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement secondNameInput;

    @FindBy (xpath = "//input[@id='postal-code']")
    private WebElement postalCodeInput;

    @FindBy (xpath = "//input[@id='continue']")
    private WebElement continueBtn;

    @FindBy (xpath = "//button[@id='cancel']")
    private WebElement cancelBtn;

    public CheckoutInfoPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isContinueBtnShown() {
        return continueBtn.isDisplayed();
    }

    public CheckoutStepTwoPage loginInput (String firstName, String secondName, String postalCode){
        firstNameInput.click();
        firstNameInput.sendKeys(firstName);

        secondNameInput.click();
        secondNameInput.sendKeys(secondName);

        postalCodeInput.click();
        postalCodeInput.sendKeys(postalCode);

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn));
        continueBtn.click();
        return new CheckoutStepTwoPage(driver);
    }
}
