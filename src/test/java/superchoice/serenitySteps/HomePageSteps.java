package superchoice.serenitySteps;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Step;
import org.junit.Assert;
import superchoice.pages.HomePage;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static superchoice.utils.dateUtil.getPastorFutureDateUsingCurrentDate;

public class HomePageSteps {
    HomePage homePage;

    @Step
    public void userIsOnTheGoogleFlightSearchWebsite() {
        homePage.open();
        assertThat(homePage.getPageTitle(), containsString("Google Flights"));
    }

    @Step
    public void userSearchesForRoundTripFlight(DataTable searchDetails) {
        List<List<String>> flightDetails = searchDetails.asLists();

        String origin = flightDetails.get(0).get(1);
        String destination = flightDetails.get(1).get(1);
        String departureDay = flightDetails.get(2).get(1).split(" ")[0];
        String returnDay = flightDetails.get(3).get(1).split(" ")[0];

        System.out.println(origin + "  " + destination + "  " + departureDay + "  " + returnDay);

        Assert.assertEquals(homePage.getSelectTripType(),"Round trip");

        homePage.enterOriginCountry(origin, "RoundTrip");
        homePage.enterDestinationCountry(destination);

        String departureDate = getPastorFutureDateUsingCurrentDate(Integer.parseInt(departureDay));
        homePage.enterDepartureDate(departureDate);

        String returnDate = getPastorFutureDateUsingCurrentDate(Integer.parseInt(returnDay));
        homePage.enterReturnDate(returnDate);

        homePage.clickSearch();
    }

    public void userSearchesForMultiCityFlight(DataTable searchDetails) {
        List<List<String>> flightDetails = searchDetails.asLists();

        String origin = flightDetails.get(0).get(1);
        String destination1 = flightDetails.get(1).get(1);
        String departureDay1 = flightDetails.get(2).get(1).split(" ")[0];

        String destination2 = flightDetails.get(3).get(1);
        String departureDay2 = flightDetails.get(4).get(1).split(" ")[0];

        String destination3 = flightDetails.get(5).get(1);
        String departureDay3 = flightDetails.get(6).get(1).split(" ")[0];

        System.out.println(origin + "  " + destination1 + "  " + departureDay1 + "  " + destination2 + "  " + departureDay2 + "  " + destination3 + "  " + departureDay3);

        homePage.selectTripType("Multi-city");

        homePage.enterOriginCountry(origin, "MultiCity");

        homePage.enterDestinationCountryForMultiCity(destination1, 1);
        homePage.enterDestinationCountryForMultiCity(destination2, 2);
        homePage.enterDestinationCountryForMultiCity(destination3, 3);

        String firstDepartureDefaultDate = getPastorFutureDateUsingCurrentDate(16);
        String departureDate1 = getPastorFutureDateUsingCurrentDate(Integer.parseInt(departureDay1));
        homePage.enterDepartureDateForMultiCity(firstDepartureDefaultDate, departureDate1, 1);

        String secondDepartureDefaultDate = getPastorFutureDateUsingCurrentDate(20);
        String departureDate2 = getPastorFutureDateUsingCurrentDate(Integer.parseInt(departureDay2));
        homePage.enterDepartureDateForMultiCity(secondDepartureDefaultDate, departureDate2, 2);

        String thirdDepartureDefaultDate = getPastorFutureDateUsingCurrentDate(24);
        String departureDate3 = getPastorFutureDateUsingCurrentDate(Integer.parseInt(departureDay3));
        homePage.enterDepartureDateForMultiCity(thirdDepartureDefaultDate, departureDate3, 3);

        homePage.clickSearch();
    }
}
