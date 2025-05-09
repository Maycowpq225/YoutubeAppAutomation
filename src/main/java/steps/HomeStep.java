package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import po.HomePO;

public class HomeStep {

    HomePO homePO = new HomePO();

    @Given("that the YouTube App was open")
    public void youtubeAppIsOpen() {
        homePO.youtubeAppIsOpen();
    }

    @Given("that the YouTube App is open and ready to use")
    public void youtubeAppIsOpenAndReadyUse() {
        homePO.youtubeAppIsOpen();
        homePO.allowNotifications();
        //homePO.acceptAllTheCookies();
    }

    @When("accept all the cookies")
    public void acceptCookies() {
        homePO.acceptAllTheCookies();
    }

    @When("I allow youtube to send notifications")
    public void allowCookies() {
        homePO.allowNotifications();
    }

    @When("I click on the search field on homeScreen")
    public void clickOnSearchField() {
        homePO.clickOnSearchField();
    }


    @Then("validate elements on the home screen")
    public void validateElementsHomeScreen() {
        homePO.validateAllElementsHomeScreen();
    }

}
