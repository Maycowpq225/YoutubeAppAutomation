package po;

import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VideoSearchingPO extends BasePO{

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.google.android.youtube:id/search_edit_text\")")
    public WebElement fieldSearch;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(UiSelector().descriptionContains(\" - play video\"))")
    public WebElement cardVideo;

    public void searchFor(String keyWord) {
        waitElementIsVisible(fieldSearch).sendKeys(keyWord);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void validateVideoResult(String keyWord) {
        waitElementIsVisible(cardVideo).isDisplayed();
        assertTrue(waitElementIsVisible(cardVideo)
                .getDomAttribute("content-desc")
                .contains(keyWord));
    }
}
