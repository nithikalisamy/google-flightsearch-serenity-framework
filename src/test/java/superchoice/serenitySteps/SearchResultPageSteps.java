package superchoice.serenitySteps;

import net.serenitybdd.annotations.Step;
import superchoice.pages.SearchResultPage;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchResultPageSteps {
    SearchResultPage searchResultPage;

    /** This function checks the search results section title and makes sure it is the expected section
     */
    @Step
    public void userShouldSeeFlightsResultsPageWith(String sectionTitle) {
        String sectionTitleFromUI = searchResultPage.getSearchResultSectionHeading(sectionTitle);
        assertThat(sectionTitleFromUI, containsStringIgnoringCase(sectionTitle));
    }

    /** This function select the first available search results
     */
    @Step
    public void userSelectsTheFirstFlightUnderBestFlights() {
        searchResultPage.userSelectsTheFirstFlightUnderBestFlights();
    }

    /** This function ensures the previously selected flight details are correct at the booking page
     */
    @Step
    public void userShouldSeeTheCorrespondingFlightInformationForFlightsSelected() {
        List<String> flightDetails = searchResultPage.getIndividualFlightDetailsFromSearchPage();

        int index = 0;
        for (String flightDetail : flightDetails) {
            System.out.println("Flight details from booking page --> " + flightDetail);
            System.out.println("Individual flight detail from selection page --> " + searchResultPage.individualFlightDetails.get(index));
            assertThat(flightDetail, containsString(searchResultPage.individualFlightDetails.get(index)));
            index++;
        }
    }
}
