package superchoice.objectRepository;

public class ObjectRepository {

    public class HomePageLocators {
        public static final String txaSearchSection_css = "div[role='search']";
        public static final String txaTripType_css = "div[role='search'] #i7";
        public static final String txtOriginCountry_css = "input[aria-label='Where from?']";
        public static final String txtOriginCountryMultiCity_css = "div > div[data-max-locations='5'] input[aria-label='Where from?']";
        public static final String txtDestinationCountry_css = "input[aria-label*='Where to?']";
        public static final String txtDestinationCountryMultiCity_xpath = "(//div[@data-max-locations='5'] //input[contains(@aria-label,'Where to?')])[var]";
        public static final String txtDestinationCountrySelection_css = "div[aria-label*='Enter your destination'] li";
        public static final String txtOriginCountrySelection_css = "div[aria-label*='Enter your origin'] li";
        public static final String txtDepartureDate_xpath = "//input[@aria-label='Departure'][1]";
        public static final String txtDepartureDateMultiCity_xpath = "(//div[@data-action='clear|reject'] //div[@data-value='var'])[1]";
        public static final String txtDepartureDatePopup_xpath = "(//input[@aria-label='Departure'])[2]";
        public static final String txtDepartureDatePopupMultiCity_xpath = "(//div[@data-action='clear|reject'] //div[@data-value='var'])[2]";
        public static final String txtReturnDate_xpath = "//input[@aria-label='Return'][1]";
        public static final String txtReturnDatePopup_xpath = "(//input[@aria-label='Return'])[2]";
        public static final String dtpSelectDate_css = "div[data-iso='var']";
        public static final String dtpSelectDateMultiCity_xpath = "(//div[@data-iso='var1'])[var2]";
        public static final String btnDone_css = "button[aria-label*='Done'] span";
        public static final String btnDoneMultiCity_xpath = "(//div[@__is_owner='true'] //button //span[text()='Done'])[var]";
        public static final String btnSearch_css = "button[aria-label='Search']";
        public static final String selectTripType_xpath = "//div[@aria-haspopup='listbox' and @aria-labelledby='i6 i7']/..";
        public static final String selectTripTypeList_xpath = "//div[@aria-haspopup='listbox' and @aria-labelledby='i6 i7']/.. //ul //li[@data-value='3']";

    }

    public class SearchResultPageLocators {
        public static final String txaTopDepartingFlightSection_xpath = "(//h3[text()='Top departing flights' or " +
                "text()='Best departing flights'])[1]";
        public static final String listTopDepartingFirstFlightSelection_xpath = "(//div[not(@style) and @role='tabpanel']" +
                "  //ul //li )[1]";
        public static final String txaBestDepartingFirstFlightSelection_xpath = "(//h2[text()='Search results']/.. //ul //li)[1]";
        public static final String txaBestDepartingFirstFlightSelectionDetails_xpath = "((//h2[text()='Search results']/.. //ul //li)[1] //span)[1]";
        public static final String txaSearchHeading_xpath = "//h2[text()='Search results']/.. //h3";
        public static final String txaReturningFlightSection_xpath = "//h3[text()='Returning flights' or text()='Best returning flights']";
        public static final String txaReturningFirstFlightSection_xpath = "//h2[text()='Search results']/.. //ul //li[1]";
        public static final String txaReturningFirstFlightSectionDetails_xpath = "(//h2[text()='Search results']/.. //ul //li[1] //span)[1]";
        public static final String txaBookingOptions_xpath = "//h2[text()='Booking options']";
        public static final String txaBookingOptionsDetails_xpath = "//div[@role='list'] //div[@role='listitem'] //div[@data-withmodel='false']";

    }
}
