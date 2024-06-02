package superchoice.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import superchoice.serenitySteps.HomePageSteps;

public class HomePageStepDefinitions {

    @Steps
    HomePageSteps homePageSteps;

    @Given("^(?:.*) is on the google flights search website$")
    public void userIsOnTheGoogleFlightSearchWebsite() {
        homePageSteps.userIsOnTheGoogleFlightSearchWebsite();
    }

    @When("^(?:.*) searches for round trip flight$")
    public void userSearchesForRoundTripFlight(DataTable searchDetails) {
        homePageSteps.userSearchesForRoundTripFlight(searchDetails);
    }

    @When("^(?:.*) searches for multi-city flight$")
    public void userSearchesForMultiCityFlight(DataTable searchDetails) {
        homePageSteps.userSearchesForMultiCityFlight(searchDetails);
    }
}
