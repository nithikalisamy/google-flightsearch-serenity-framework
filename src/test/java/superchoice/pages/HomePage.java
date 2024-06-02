package superchoice.pages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.ui.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static superchoice.objectRepository.ObjectRepository.HomePageLocators.*;

public class HomePage extends PageObject {

    @FindBy(css = txaSearchSection_css)
    private WebElementFacade txaSearchSection;
    @FindBy(xpath = selectTripType_xpath)
    private WebElementFacade selectTripType;
    @FindBy(xpath = selectTripTypeList_xpath)
    private WebElementFacade selectTripTypeList;
    @FindBy(css = txaTripType_css)
    private WebElementFacade txaTripType;
    @FindBy(css = txtOriginCountry_css)
    private WebElementFacade txtOriginCountry;
    @FindBy(css = txtOriginCountryMultiCity_css)
    private WebElementFacade txtOriginCountryMultiCity;
    @FindBy(xpath = txtDestinationCountryMultiCityTotalCount_xpath)
    private List<WebElementFacade> txtDestinationCountryMultiCityTotalCount;
    @FindBy(css = txtDestinationCountry_css)
    private WebElementFacade txtDestinationCountry;
    @FindBy(css = txtDestinationCountrySelection_css)
    private WebElementFacade txtDestinationCountrySelection;
    @FindBy(css = txtOriginCountrySelection_css)
    private WebElementFacade txtOriginCountrySelection;
    @FindBy(xpath = txtDepartureDate_xpath)
    private WebElementFacade txtDepartureDate;
    @FindBy(xpath = txtDepartureDatePopup_xpath)
    private WebElementFacade txtDepartureDatePopup;
    @FindBy(xpath = txtReturnDate_xpath)
    private WebElementFacade txtReturnDate;
    @FindBy(xpath = txtReturnDatePopup_xpath)
    private WebElementFacade txtReturnDatePopup;
    @FindBy(css = btnDone_css)
    private WebElementFacade btnDone;
    @FindBy(css = btnSearch_css)
    private WebElementFacade btnSearch;


    public String getPageTitle() {
        return getDriver().getTitle();
    }

    public String getSelectTripType() {
        withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaSearchSection).waitUntilVisible();
        return txaTripType.waitUntilVisible().getText();
    }

    public void selectTripType(String type) {
        withTimeoutOf(Duration.ofSeconds(60)).waitFor(txaSearchSection).waitUntilVisible();
        selectTripType.waitUntilVisible().click();
        if(type.equalsIgnoreCase("MultiCity")) {
            $(selectTripTypeList_xpath.replace("var", String.valueOf(3))).waitUntilVisible().click();
        }
        // Wait until trip selection to disappear
        waitFor(ExpectedConditions.invisibilityOfElementLocated(By.xpath(selectTripTypeList_xpath)));
    }

    public void addAdditionalStopOverFlightToSearch() {
        int size = txtDestinationCountryMultiCityTotalCount.size();
        $(Button.withText("Add flight")).waitUntilVisible().click();

        /* Wait until newly added flight section to be visible
         *  size will get the added additional flight entry index
         */
        waitFor(ExpectedConditions.visibilityOf(txtDestinationCountryMultiCityTotalCount.get(size)));
    }

    public void enterOriginCountry(String origin, String tripType) {
        if (tripType.equalsIgnoreCase("RoundTrip")) {
            typeInto(txtOriginCountry, origin);
        } else if (tripType.equalsIgnoreCase("MultiCity")) {
            typeInto(txtOriginCountryMultiCity, origin);
        }
        txtOriginCountrySelection.waitUntilClickable().click();
    }

    public void enterDestinationCountry(String destination) {
        typeInto(txtDestinationCountry, destination);
        txtDestinationCountrySelection.waitUntilClickable().click();
    }

    public void enterDestinationCountryForMultiCity(String destination, int index) {
        String destinationCountryXpath = txtDestinationCountryMultiCity_xpath.replace("var", String.valueOf(index));
        typeInto($(destinationCountryXpath), destination);
        txtDestinationCountrySelection.waitUntilClickable().click();
    }

    public void enterDepartureDate(String departureDate) {
        txtDepartureDate.waitUntilVisible().click();
        txtDepartureDatePopup.waitUntilVisible();
        //Initial departure pricing could not be handled with explicit waits due to dynamic elements/loading, hence introduced wait
        waitABit(1000);
        $(By.cssSelector(dtpSelectDate_css.replace("var", departureDate))).waitUntilVisible().click();
        btnDone.waitUntilClickable().click();
//        System.out.println("Departure Date" + txtDepartureDate.waitUntilVisible().getValue());
    }

    public void enterReturnDate(String returnDate) {
        txtReturnDate.waitUntilVisible().click();
        txtReturnDatePopup.waitUntilVisible();
        //Initial departure pricing could not be handled with explicit waits due to dynamic elements/loading, hence introduced wait
        waitABit(1000);
        $(By.cssSelector(dtpSelectDate_css.replace("var", returnDate))).waitUntilVisible().click();
        btnDone.waitUntilClickable().click();
//        System.out.println("Return Date" + txtReturnDate.waitUntilVisible().getValue());
    }

    public void enterDepartureDateForMultiCity(String firstDepartureDefaultDate, String departureDate, int indexDate) {
        String departureDateXpath = txtDepartureDateMultiCity_xpath.replace("var", firstDepartureDefaultDate);
        $(departureDateXpath).waitUntilVisible().click();

        String departureDatePopUpXpath = txtDepartureDatePopupMultiCity_xpath.replace("var", firstDepartureDefaultDate);
        $(departureDatePopUpXpath).waitUntilVisible();

        //Initial departure pricing could not be handled with explicit waits due to dynamic elements/loading, hence introduced wait
        waitABit(1000);

        $(By.xpath(dtpSelectDateMultiCity_xpath.replace("var1", departureDate).replace("var2", String.valueOf(indexDate + 1)))).waitUntilVisible().click();

        $(By.xpath(btnDoneMultiCity_xpath.replace("var", String.valueOf(indexDate)))).waitUntilVisible().click();

//        departureDateXpath = txtDepartureDateMultiCity_xpath.replace("var", departureDate);
//        System.out.println("Departure Date : " + $(departureDateXpath).waitUntilVisible().getAttribute("data-value"));
    }

    public void clickSearch() {
        btnSearch.waitUntilClickable().click();
    }
}
