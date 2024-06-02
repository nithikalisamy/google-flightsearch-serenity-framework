package superchoice.serenitySteps;

import net.serenitybdd.annotations.Step;
import superchoice.pages.SearchResultPage;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchResultPageSteps {
    SearchResultPage searchResultPage;

    @Step
    public void userShouldSeeFlightsResultsPageWith(String sectionTitle) {
        String sectionTitleFromUI = searchResultPage.getSearchResultSectionHeading(sectionTitle);
        System.out.println("sectionTitle in userShouldSeeFlightsResultsPageWith: " + sectionTitle);
        assertThat(sectionTitleFromUI, containsStringIgnoringCase(sectionTitle));
    }

    @Step
    public void userSelectsTheFirstFlightUnderBestFlights() {
        searchResultPage.userSelectsTheFirstFlightUnderBestFlights();
    }

    @Step
    public void userShouldSeeTheCorrespondingFlightInformationForFlightsSelected() {
        ArrayList<String> flightDetails = searchResultPage.getIndividualFlightDetailsFromSearchPage();

        int index = 0;
        for (String flightDetail : flightDetails) {
            System.out.println("Flight details from booking page --> " + flightDetail);
            System.out.println("Individual flight detail from selection page --> " + searchResultPage.individualFlightDetails.get(index));
            assertThat(flightDetail, containsString(searchResultPage.individualFlightDetails.get(index)));
            index++;
        }
    }
}
