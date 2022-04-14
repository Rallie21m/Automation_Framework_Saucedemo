package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.Collections;
import java.util.NoSuchElementException;

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
        FluentWait fluentWait = new FluentWait(driver)
                .withTimeout(Duration.ofSeconds(20))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoreAll(Collections.singleton(NoSuchElementException.class));
        fluentWait.until(ExpectedConditions.elementToBeClickable(finishBtn));
        finishBtn.click();
        return new CheckoutCompletePage (driver);
    }
}
