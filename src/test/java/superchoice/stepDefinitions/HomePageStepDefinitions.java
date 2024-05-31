package superchoice.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

public class HomePageStepDefinitions {

    @Steps
    HomePageSteps homePageSteps;

    @Given("Sally is on the google flights search website")
    public void sallyIsOnTheGoogleFlightSearchWebsite() {
        homePageSteps.userIsOnTheGoogleFlightSearchWebsite();
    }

    @When("Sally searches for round trip flight")
    public void sallySearchesForRoundTripFlight(DataTable searchDetails) {
        homePageSteps.userSearchesForRoundTripFlight(searchDetails);
    }

    @When("Sally searches for multi-city flight")
    public void sallySearchesForMultiCityFlight(DataTable searchDetails) {
    }

    @Then("Sally should see flights results page with {string}")
    public void sallyShouldSeeFlightsResultsPageWith(String sectionTitle) {
        
    }

    @When("Sally selects the first flight under best flights")
    public void sallySelectsTheFirstFlightUnderBestFlights() {
        
    }

    @And("Sally should see the corresponding flight information for flights selected")
    public void sallyShouldSeeTheCorrespondingFlightInformationForFlightsSelected() {
    }
}
