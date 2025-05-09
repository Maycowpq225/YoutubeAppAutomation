package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import po.VideoSearchingPO;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class VideoSearchingStep {

    VideoSearchingPO videoSearchingPO = new VideoSearchingPO();

    @When("search on the field for the word {string}")
    public void searchFor(String keyWord) {
        videoSearchingPO.searchFor(keyWord);
    }

    @And("click on the filter {string}")
    public void clickFilter(String filter) {
        videoSearchingPO.clickOnFilter(filter);
    }

    @Then("the first result must contain the word {string} on the title")
    public void resultContains(String keyWord) {
        assertTrue(videoSearchingPO.validateVideoResult(keyWord));
    }

    @Then("just the filter {string} should appear on the screen")
    public void validateFilterResults(String filter) {
        assertTrue(videoSearchingPO.validateFilterResults(filter));
    }
}
