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

    @When("accept all the cookies")
    public void acceptCookies() {
        homePO.acceptAllTheCookies();
    }

    @When("I allow youtube to send notifications")
    public void allowCookies() {
        homePO.allowNotifications();
    }


    @Then("validate elements on the home screen")
    public void validateElementsHomeScreen() {
        homePO.validateAllElementsHomeScreen();
    }

}
