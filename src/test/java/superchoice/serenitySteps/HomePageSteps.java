package superchoice.serenitySteps;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.Serenity;
import org.junit.Assert;
import superchoice.testData.GoogleFlightDefaultValues;
import superchoice.pages.HomePage;

import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static superchoice.utils.DateUtil.getPastorFutureDateUsingCurrentDate;

public class HomePageSteps {
    HomePage homePage = new HomePage();
    GoogleFlightDefaultValues googleFlightDefaultValues = new GoogleFlightDefaultValues();

    /** This function opens the Google flight home page and then checks the page title
     */
    @Step
    public void userIsOnTheGoogleFlightSearchWebsite() {
        homePage.open();
        assertThat(homePage.getPageTitle(), containsString("Google Flights"));
    }

    /** Function is used to enter all the necessary details required for round trip search by extracting the data table
     * and assigning it to the local variable. Then all the details are passed into the relevant element in Home page
     * for locating and entering the values
     */
    @Step
    public void userSearchesForRoundTripFlight(DataTable searchDetails) {
        Serenity.setSessionVariable("tripType").to("RoundTrip");

        List<List<String>> flightDetails = searchDetails.asLists();

        String origin = flightDetails.get(0).get(1);
        String destination = flightDetails.get(1).get(1);
        String departureDay = flightDetails.get(2).get(1).split(" ")[0];
        String returnDay = flightDetails.get(3).get(1).split(" ")[0];

        System.out.println(origin + "  " + destination + "  " + departureDay + "  " + returnDay);

        Assert.assertEquals(homePage.getSelectTripType(), "Round trip");

        homePage.enterOriginCountry(origin, "RoundTrip");
        homePage.enterDestinationCountry(destination);

        String departureDate = getPastorFutureDateUsingCurrentDate(Integer.parseInt(departureDay));
        homePage.enterDepartureDate(departureDate);

        String returnDate = getPastorFutureDateUsingCurrentDate(Integer.parseInt(returnDay));
        homePage.enterReturnDate(returnDate);

        homePage.clickSearch();
    }

    /** Function is used to enter all the necessary details required for multi city search by extracting the data table
     * and assigning it to the local variable. Then all the details are passed into the relevant element in Home page
     * for locating and entering the values
     */
    @Step
    public void userSearchesForMultiCityFlight(DataTable searchDetails) {
        Serenity.setSessionVariable("tripType").to("MultiCity");

        /* Extract the test data from Data table and assign the corresponding details into the respective
        variable to execute the scenario
         */
        List<List<String>> flightDetails = searchDetails.asLists();

        String origin = flightDetails.get(0).get(1);
        String destination1 = flightDetails.get(1).get(1);
        String departureDay1 = flightDetails.get(2).get(1).split(" ")[0];

        String destination2 = flightDetails.get(3).get(1);
        String departureDay2 = flightDetails.get(4).get(1).split(" ")[0];

        String destination3 = flightDetails.get(5).get(1);
        String departureDay3 = flightDetails.get(6).get(1).split(" ")[0];

        System.out.println(origin + "  " + destination1 + "  " + departureDay1 + "  " + destination2 + "  " + departureDay2 + "  " + destination3 + "  " + departureDay3);

        homePage.selectTripType("MultiCity");

        homePage.addAdditionalStopOverFlightToSearch();

        homePage.enterOriginCountry(origin, "MultiCity");

        //Index is based on the number of destination country to avoid hard coded locators
        homePage.enterDestinationCountryForMultiCity(destination1, 1);
        homePage.enterDestinationCountryForMultiCity(destination2, 2);
        homePage.enterDestinationCountryForMultiCity(destination3, 3);

        /* Google flight logic to show the default date is calculated to be 16 days from today and the following
        subsequent departure defaults date delta is 4 days from 16 days. this has been configured inside the
        page elements and logic is used below to identify the correct departure date based on the above calculation.
        This is used to avoid the hard coded locators to be used inside the code.
        And then the expected departure from test data is passed onto the page files to select for all destinations.
         */
        String firstDepartureDefaultDate = getPastorFutureDateUsingCurrentDate(googleFlightDefaultValues.getDefaultDepartureDateValue());
        String departureDate1 = getPastorFutureDateUsingCurrentDate(Integer.parseInt(departureDay1));
        homePage.enterDepartureDateForMultiCity(firstDepartureDefaultDate, departureDate1, 1);

        String secondDepartureDefaultDate = getPastorFutureDateUsingCurrentDate(googleFlightDefaultValues.getDefaultDepartureDateValue()
                + googleFlightDefaultValues.getDefaultDepartureDateDelta());
        String departureDate2 = getPastorFutureDateUsingCurrentDate(Integer.parseInt(departureDay2));
        homePage.enterDepartureDateForMultiCity(secondDepartureDefaultDate, departureDate2, 2);

        String thirdDepartureDefaultDate = getPastorFutureDateUsingCurrentDate(googleFlightDefaultValues.getDefaultDepartureDateValue()
                + (googleFlightDefaultValues.getDefaultDepartureDateDelta() * 2));
        String departureDate3 = getPastorFutureDateUsingCurrentDate(Integer.parseInt(departureDay3));
        homePage.enterDepartureDateForMultiCity(thirdDepartureDefaultDate, departureDate3, 3);

        homePage.clickSearch();
    }
}
