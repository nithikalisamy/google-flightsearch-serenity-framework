package superchoice.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import java.time.Duration;

import static superchoice.objectRepository.ObjectRepository.HomePageLocators.*;
import static superchoice.utils.dateUtil.*;

public class HomePage extends PageObject {

    @FindBy(css = txtDepartureCountry_css)
    private WebElementFacade txtDepartureCountry;
    @FindBy(css = txtDestinationCountry_css)
    private WebElementFacade txtDestinationCountry;
    @FindBy(css = txtDestinationCountrySelection_css)
    private WebElementFacade txtDestinationCountrySelection;
    @FindBy(css = txtDepartureDate_css)
    private WebElementFacade txtDepartureDate;
    @FindBy(css = txtReturnDate_css)
    private WebElementFacade txtReturnDate;
    @FindBy(css = dtpSelectDate_css)
    private WebElementFacade dtpSelectDate;
    @FindBy(css = btnDone_css)
    private WebElementFacade btnDone;
    @FindBy(css = btnSearch_css)
    private WebElementFacade btnSearch;
    @FindBy(xpath = txaTopDepartingFlightSection_xpath)
    private WebElementFacade txaTopDepartingFlightSection;
    @FindBy(xpath = listTopDepartingFirstFlightSelection_xpath)
    private WebElementFacade listTopDepartingFirstFlightSelection;
    @FindBy(xpath = listBestDepartingFirstFlightSelection_xpath)
    private WebElementFacade listBestDepartingFirstFlightSelection;
    @FindBy(xpath = txaReturningFlightSection_xpath)
    private WebElementFacade txaReturningFlightSection;
    @FindBy(xpath = txaReturningFirstFlightSection_xpath)
    private WebElementFacade txaReturningFirstFlightSection;
    @FindBy(xpath = txaBookingOptions_xpath)
    private WebElementFacade txaBookingOptions;

    public String getPageTitle() {

        txtDepartureCountry.waitUntilVisible().type("Sydney");
        txtDestinationCountry.waitUntilVisible().typeAndTab("NewYork");
        txtDestinationCountrySelection.waitUntilClickable().click();

        String departureDate = getPastorFutureDateUsingCurrentDate(10);
        System.out.println(txtDepartureDate.getValue());
        txtDepartureDate.waitUntilClickable().click();
        $(By.cssSelector(dtpSelectDate_css.replace("var",departureDate))).waitUntilVisible().click();
        btnDone.waitUntilClickable().click();
        waitABit(2000);
        System.out.println("Departure Date" + txtDepartureDate.getValue());


        String returnDate = getPastorFutureDateUsingCurrentDate(65);
        System.out.println(txtReturnDate.getValue());
        txtReturnDate.waitUntilClickable().click();
        $(By.cssSelector(dtpSelectDate_css.replace("var",returnDate))).waitUntilVisible().click();
        waitABit(2000);
        btnDone.waitUntilClickable().click();
        System.out.println("Return Date" + txtReturnDate.getValue());

        btnSearch.waitUntilClickable().click();

        withTimeoutOf(Duration.ofSeconds(10)).waitFor(txaTopDepartingFlightSection).waitUntilVisible();
        String flightResultTopOrBest = txaTopDepartingFlightSection.waitUntilVisible().getText();
        if(flightResultTopOrBest.contains("Top")) {
            withTimeoutOf(Duration.ofSeconds(30)).waitFor(listTopDepartingFirstFlightSelection).waitUntilClickable().click();
        } else if(flightResultTopOrBest.contains("Best")) {
            withTimeoutOf(Duration.ofSeconds(30)).waitFor(listBestDepartingFirstFlightSelection).waitUntilClickable().click();
        }

        withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaReturningFlightSection).waitUntilVisible();
        System.out.println(txaReturningFlightSection.waitUntilVisible().getText());
        withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaReturningFirstFlightSection).waitUntilClickable().click();

        withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaBookingOptions).waitUntilVisible();
        txaBookingOptions.waitUntilClickable().getText();

        return getDriver().getTitle();
    }
}
