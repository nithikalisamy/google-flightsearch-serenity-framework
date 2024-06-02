package superchoice.serenitySteps;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import superchoice.pages.HomePage;
import superchoice.pages.SearchResultPage;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;
import static superchoice.utils.dateUtil.getPastorFutureDateUsingCurrentDate;

public class SearchResultPageSteps {
    SearchResultPage searchResultPage;

    @Step
    public void userShouldSeeFlightsResultsPageWith(String sectionTitle) {
        String sectionTitleFromUI = searchResultPage.getSearchResultSectionHeading(sectionTitle);
        System.out.println("sectionTitle in userShouldSeeFlightsResultsPageWith: "+ sectionTitle);
        assertThat(sectionTitleFromUI, containsStringIgnoringCase(sectionTitle));
    }

    @Step
    public void userSelectsTheFirstFlightUnderBestFlights() {
        searchResultPage.userSelectsTheFirstFlightUnderBestFlights();
    }

    @Step
    public void userShouldSeeTheCorrespondingFlightInformationForFlightsSelected() {
        ArrayList<String> flightDetails = searchResultPage.getIndividualFlightDetailsFromSearchPage();

        String departingFlightDetails = Serenity.sessionVariableCalled("departingFlightDetails");
        String returningFlightDetails = Serenity.sessionVariableCalled("returningFlightDetails");

        System.out.println("departingFlightDetails : " + departingFlightDetails);
        System.out.println("returningFlightDetails : " + returningFlightDetails);

        System.out.println("flightInfo departing from booking page : " + flightDetails.get(0));
        assertThat(flightDetails.get(0), containsString(departingFlightDetails));
        System.out.println("flightInfo returning from booking page: " + flightDetails.get(1));
        assertThat(flightDetails.get(1), containsString(returningFlightDetails));
    }
}
