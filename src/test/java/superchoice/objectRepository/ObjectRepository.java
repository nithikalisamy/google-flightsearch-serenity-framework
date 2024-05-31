package superchoice.objectRepository;

public class ObjectRepository {

    public class HomePageLocators {
        public static final String txtDepartureCountry_css = "input[aria-label='Where from?']";
        public static final String txtDestinationCountry_css = "input[aria-label*='Where to?']";
        public static final String txtDestinationCountrySelection_css = "div[aria-label*='Enter your destination'] li";
        public static final String txtDepartureDate_css = "input[aria-label*='Departure']";
        public static final String txtReturnDate_css = "input[aria-label*='Return']";
        public static final String dtpSelectDate_css = "div[data-iso='var']";
        public static final String btnDone_css = "button[aria-label*='Done'] span";
        public static final String btnSearch_css = "button[aria-label='Search']";
//        public static final String txaTopDepartingFlightSection_xpath = "//div[not(@style) and @role='tabpanel'] " +
//                "//h3[text()='Top departing flights' or text()='Best departing flights' ]";
        public static final String txaTopDepartingFlightSection_xpath = "(//h3[text()='Top departing flights' or text()='Best departing flights'])[1]";
        public static final String listTopDepartingFirstFlightSelection_xpath = "(//div[not(@style) and @role='tabpanel']" +
                "  //ul //li )[1]";
        public static final String listBestDepartingFirstFlightSelection_xpath = "(//h2[text()='Search results']/.. //ul //li)[1]";
        public static final String txaReturningFlightSection_xpath = "//h3[text()='Returning flights']";
        public static final String txaReturningFirstFlightSection_xpath = "//h2[text()='Search results']/.. //ul //li[1]";
        public static final String txaBookingOptions_xpath = "//h2[text()='Booking options']";

    }

}
