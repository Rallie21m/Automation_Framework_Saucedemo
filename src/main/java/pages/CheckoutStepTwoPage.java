package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutStepTwoPage {
    protected WebDriver driver;

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishBtn;

    public CheckoutStepTwoPage (WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isFinishBtnShown() {
        return finishBtn.isDisplayed();
    }

    public CheckoutCompletePage checkoutFinal (){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        finishBtn.click();
        return new CheckoutCompletePage (driver);
    }
}
