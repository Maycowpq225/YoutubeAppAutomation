package steps;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;

public class Home {

    @Given("that I open the youtube App")
    public void acepptCookies() throws URISyntaxException, MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options()
                .setUdid("emulator-5554")
                .setAppPackage("com.google.android.youtube")
                .setAppActivity("com.google.android.apps.youtube.app.WatchWhileActivity");
        AndroidDriver driver = new AndroidDriver(
                new URI("http://127.0.0.1:4723").toURL(), options
        );
        try {
            System.out.println("Olá mundo");
            WebElement el = driver.findElement(AppiumBy.xpath("//Button"));
            el.click();
            driver.getPageSource();
        } finally {
            driver.quit();
        }

    }

}
