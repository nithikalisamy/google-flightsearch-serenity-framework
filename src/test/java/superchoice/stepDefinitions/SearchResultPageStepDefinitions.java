package superchoice.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import superchoice.serenitySteps.HomePageSteps;
import superchoice.serenitySteps.SearchResultPageSteps;

public class SearchResultPageStepDefinitions {

    @Steps
    SearchResultPageSteps searchResultPageSteps;

    @Then("^(?:.*) should see flights results page with \"([^\"]*)\"$")
    public void userShouldSeeFlightsResultsPageWith(String sectionTitle) {
        searchResultPageSteps.userShouldSeeFlightsResultsPageWith(sectionTitle);
    }

    @When("^(?:.*) selects the first flight under best flights$")
    public void userSelectsTheFirstFlightUnderBestFlights() {
        searchResultPageSteps.userSelectsTheFirstFlightUnderBestFlights();
    }

    @And("^(?:.*) should see the corresponding flight information for flights selected$")
    public void userShouldSeeTheCorrespondingFlightInformationForFlightsSelected() {
        searchResultPageSteps.userShouldSeeTheCorrespondingFlightInformationForFlightsSelected();
    }
}
