package superchoice.stepDefinitions;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Step;
import superchoice.pages.HomePage;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePageSteps {
    HomePage homePage;

    @Step
    public void userIsOnTheGoogleFlightSearchWebsite() {
        homePage.open();
        assertThat(homePage.getPageTitle(), containsString("Google Flights"));
    }

    @Step
    public void userSearchesForRoundTripFlight(DataTable searchDetails) {

    }
}
