package po;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

import java.util.List;

public class VideoSearchingPO extends BasePO {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.google.android.youtube:id/search_edit_text\")")
    public WebElement fieldSearch;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\" - play video\")")
    public List<WebElement> cardVideo;

    @AndroidFindBy(uiAutomator = "new UiSelector().descriptionContains(\" - play Short\")")
    public List<WebElement> cardShort;

    @AndroidFindBy(id = "com.google.android.youtube:id/results")
    public WebElement containerResults;

    public void searchFor(String keyWord) {
        waitElementIsVisible(fieldSearch).sendKeys(keyWord);
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));
    }

    public void clickOnFilter(String filter) {
        waitElementIsVisible(containerResults);
        scrollDirection("down", 2);
        scrollDirection("up", 2);
        driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.TextView\").text(\"" + filter + "\")")).click();
    }

    public boolean validateVideoResult(String keyWord) {
        return waitElementIsVisible(cardVideo.get(0)).isDisplayed()
                && waitElementIsVisible(cardVideo.get(0)).getDomAttribute("content-desc").contains(keyWord);
    }

    public boolean validateFilterResults(String filter) {
        int cardShortCounted = 0;
        int cardVideosCounted = 0;
        for (int i = 0; i < 2; i++) {
            if(i != 0) scrollDirection("down", 2);
            cardShortCounted = cardShortCounted + cardShort.size();
            cardVideosCounted = cardVideosCounted + cardVideo.size();
        }
        switch (filter) {
            case "Shorts" -> {
                return cardShortCounted > 0 && cardVideosCounted == 0;
            }
            case "Videos" -> {
                return cardVideosCounted > 0 && cardShortCounted == 0;
            }
            default -> {
                System.out.println("Filter not found");
                return false;
            }
        }
    }
}
