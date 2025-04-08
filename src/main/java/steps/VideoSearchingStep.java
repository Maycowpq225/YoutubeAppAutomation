package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import po.VideoSearchingPO;

public class VideoSearchingStep {

    VideoSearchingPO videoSearchingPO = new VideoSearchingPO();

    @When("search on the field for the word {string}")
    public void searchFor(String keyWord) {
        videoSearchingPO.searchFor(keyWord);
    }

    @Then("The first result must contains the word {string} on the title")
    public void resultContains(String keyWord) {
        videoSearchingPO.validateVideoResult(keyWord);
    }
}
