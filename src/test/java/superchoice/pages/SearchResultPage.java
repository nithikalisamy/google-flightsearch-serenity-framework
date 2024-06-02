package superchoice.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import static superchoice.objectRepository.ObjectRepository.SearchResultPageLocators.*;

public class SearchResultPage extends PageObject {

    public ArrayList<String> individualFlightDetails = new ArrayList<>();

    @FindBy(xpath = txaTopDepartingFlightSection_xpath)
    private WebElementFacade txaTopDepartingFlightSection;
    @FindBy(xpath = listTopDepartingFirstFlightSelection_xpath)
    private WebElementFacade listTopDepartingFirstFlightSelection;
    @FindBy(xpath = txaBestDepartingFirstFlightSelection_xpath)
    private WebElementFacade txaBestDepartingFirstFlightSelection;
    @FindBy(xpath = txaBestDepartingFirstFlightSelectionDetails_xpath)
    private WebElementFacade txaBestDepartingFirstFlightSelectionDetails;
    @FindBy(xpath = txaReturningFlightSection_xpath)
    private WebElementFacade txaReturningFlightSection;
    @FindBy(xpath = txaReturningFirstFlightSection_xpath)
    private WebElementFacade txaReturningFirstFlightSection;
    @FindBy(xpath = txaReturningFirstFlightSectionDetails_xpath)
    private WebElementFacade txaReturningFirstFlightSectionDetails;
    @FindBy(xpath = txaBookingOptions_xpath)
    private WebElementFacade txaBookingOptions;
    @FindBy(xpath = txaBookingOptionsDetails_xpath)
    private List<WebElementFacade> txaBookingOptionsDetails;
    @FindBy(xpath = txaSearchHeading_xpath)
    private WebElementFacade txaSearchHeading;

    /** Returns section title to steps page for assertion to validate the correct sub heading is displayed
     */
    public String getSearchResultSectionHeading(String sectionTitle) {
        String sectionTitleFromUI = null;
        Serenity.setSessionVariable("sectionTitle").to(sectionTitle);
        if (StringUtils.containsIgnoreCase(sectionTitle, "flights")) {
            sectionTitleFromUI = withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaSearchHeading).waitUntilVisible().getText();
        } else if (sectionTitle.equalsIgnoreCase("Booking options")) {
            sectionTitleFromUI = withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaBookingOptions).waitUntilVisible().getText();
        }
        return sectionTitleFromUI;
    }

    /** Selects the first available result option from various search results on corresponding round or multi city
     * searches. Also, adds the individual flight details to the class variable for assertion
     */
    public void userSelectsTheFirstFlightUnderBestFlights() {
        String sectionTitle = Serenity.sessionVariableCalled("sectionTitle");
        String tripType = Serenity.sessionVariableCalled("tripType");

        System.out.println("sectionTitle in userSelectsTheFirstFlightUnderBestFlights: " + sectionTitle);
        System.out.println("tripType in userSelectsTheFirstFlightUnderBestFlights: " + tripType);

        withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaReturningFirstFlightSection).waitUntilVisible();
        individualFlightDetails.add(txaReturningFirstFlightSectionDetails.getAttribute("aria-label"));
        txaReturningFirstFlightSection.waitUntilClickable().click();
    }

    /** Common function added to return round trip and multi trip details to be steps page for assertion
     */
    public ArrayList<String> getIndividualFlightDetailsFromSearchPage() {
        ArrayList<String> flightDetails = new ArrayList<>();

        for (WebElementFacade element : txaBookingOptionsDetails) {
            String details = element.find(By.tagName("span")).getAttribute("aria-label");
            flightDetails.add(details);
        }

        return flightDetails;
    }
}
