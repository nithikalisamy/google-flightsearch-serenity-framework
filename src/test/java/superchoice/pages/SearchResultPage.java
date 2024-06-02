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

    public String getSearchResultSectionHeading(String sectionTitle) {
        String sectionTitleFromUI = null;
        Serenity.setSessionVariable("sectionTitle").to(sectionTitle);
        if(StringUtils.containsIgnoreCase(sectionTitle, "flights")) {
            sectionTitleFromUI = withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaSearchHeading).waitUntilVisible().getText();
        } else if (sectionTitle.equalsIgnoreCase("Booking options")) {
            sectionTitleFromUI = withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaBookingOptions).waitUntilVisible().getText();
        }
        return sectionTitleFromUI;
    }

    public void userSelectsTheFirstFlightUnderBestFlights() {
        String sectionTitle = Serenity.sessionVariableCalled("sectionTitle");
        System.out.println("sectionTitle in userSelectsTheFirstFlightUnderBestFlights: " +sectionTitle);
        if(StringUtils.containsIgnoreCase(sectionTitle, "returning")) {
//            withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaReturningFlightSection).waitUntilVisible();
//            System.out.println(txaReturningFlightSection.waitUntilVisible().getText());

            withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaReturningFirstFlightSection).waitUntilVisible();
            Serenity.setSessionVariable("returningFlightDetails").to(txaReturningFirstFlightSectionDetails.getAttribute("aria-label"));
            txaReturningFirstFlightSection.waitUntilClickable().click();
        }
//        else {
////            String flightResultTopOrBest = withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaTopDepartingFlightSection).waitUntilVisible().getText();
//            String flightResultTopOrBest = withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaBookingOptions).waitUntilVisible().getText();
//            if(StringUtils.containsIgnoreCase(flightResultTopOrBest, "Top departing")) {
//                withTimeoutOf(Duration.ofSeconds(30)).waitFor(listTopDepartingFirstFlightSelection).waitUntilClickable().click();
//            } else if(StringUtils.containsIgnoreCase(flightResultTopOrBest, "Best departing")) {
//                withTimeoutOf(Duration.ofSeconds(30)).waitFor(listBestDepartingFirstFlightSelection).waitUntilClickable().click();
//            }
//        }
         else {
            withTimeoutOf(Duration.ofSeconds(30)).waitFor(txaBestDepartingFirstFlightSelection).waitUntilVisible();
            Serenity.setSessionVariable("departingFlightDetails").to(txaBestDepartingFirstFlightSelectionDetails.getAttribute("aria-label"));
            txaBestDepartingFirstFlightSelection.waitUntilClickable().click();
        }
    }

    public ArrayList<String> getIndividualFlightDetailsFromSearchPage() {
        ArrayList<String> flightDetails = new ArrayList<>();

        for(WebElementFacade element: txaBookingOptionsDetails)      {
            String details = element.find(By.tagName("span")).getAttribute("aria-label");
            flightDetails.add(details);
        }

        return flightDetails;
    }
}
