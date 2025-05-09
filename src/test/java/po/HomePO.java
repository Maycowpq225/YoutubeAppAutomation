package po;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;


public class HomePO extends BasePO {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")")
    private WebElement btnAllowNotifications;

    @AndroidFindBy(uiAutomator = "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(UiSelector().text(\"Accept all\"))")
    private WebElement btnAcceptAllCookies;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Search YouTube\")")
    private WebElement fieldSearchYouTube;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Explore Menu\")")
    private WebElement btnExploreMenu;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Search with your voice\")")
    private WebElement btnMicrofone;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.view.ViewGroup\")")
    private List<WebElement> bannerTrySearchingToGetStarted;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.google.android.youtube:id/youtube_logo\")")
    private WebElement lblYouTube;

    @AndroidFindBy(uiAutomator = "new UiSelector().className(\"android.widget.ImageView\").instance(3)")
    private WebElement imgLogoYoutube;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Notifications\")")
    private WebElement btnNotifications;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Search\")")
    private WebElement btnSearch;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Account\")")
    private WebElement btnAccount;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Home\")")
    private WebElement menuHome;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Shorts\")")
    private WebElement menuShorts;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Subscriptions\")")
    private WebElement menuSubscriptions;

    @AndroidFindBy(uiAutomator = "new UiSelector().description(\"Library\")")
    private WebElement menuLibrary;

    public void youtubeAppIsOpen() {
        waitElementIsVisible(btnAllowNotifications);
        assertEquals(Objects.requireNonNull(driver.currentActivity()),
                "com.android.permissioncontroller.permission.ui.GrantPermissionsActivity",
                "Youtube App is open");
    }

    public void allowNotifications() {
        waitElementIsVisible(btnAllowNotifications).click();
    }

    public void clickOnSearchField() {
        waitElementIsVisible(fieldSearchYouTube).click();
    }

    public void acceptAllTheCookies() {
        waitElementIsVisible(btnAcceptAllCookies).click();
    }

    public void validateAllElementsHomeScreen() {
        List<WebElement> elements = List.of(fieldSearchYouTube, btnExploreMenu, btnMicrofone,
                bannerTrySearchingToGetStarted.get(bannerTrySearchingToGetStarted.size()-1), lblYouTube, imgLogoYoutube,
                btnNotifications, btnSearch, btnAccount,
                menuHome, menuShorts, menuSubscriptions, menuLibrary);

        List<WebElement> visibleElements = wait.until(ExpectedConditions.visibilityOfAllElements(elements));
        assertEquals(visibleElements.size(), elements.size());
    }
}
