package po;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverConfig;

import java.util.concurrent.TimeUnit;

public class BasePO {
    public AndroidDriver driver;
    public WebDriverWait wait;

    public BasePO() {
        driver = DriverConfig.shared().driver;
        wait = DriverConfig.shared().wait;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public WebElement waitElementIsVisible(WebElement element) {
        DriverConfig.shared().wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    public WebElement waitElementIsClickable(WebElement element) {
        DriverConfig.shared().wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
    public WebElement waitElementIsClickableAndClick(WebElement element, int timeoutSeconds) {
        StopWatch timer = new StopWatch();
        timer.start();
        while (timer.getTime(TimeUnit.SECONDS) < timeoutSeconds) {
            try {
                element.click();
                timer.stop();
                return element;
            } catch (ElementClickInterceptedException e) {
                System.out.println("Element not clickable at "
                        + timer.getTime(TimeUnit.SECONDS)
                        + " seconds");
                if (timer.getTime(TimeUnit.SECONDS) > 4) throw e;
            }
        }

        return element;
    }

    public WebElement findElementByText(String text) {
        return DriverConfig.shared().driver.findElement(By.xpath("//*[text()=\"" + text + "\"]"));
    }

    public boolean elementIsVisible(WebElement element) {
        try {
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }

    }
}
