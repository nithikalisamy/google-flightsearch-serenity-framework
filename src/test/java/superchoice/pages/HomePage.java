package superchoice.pages;

import net.serenitybdd.core.pages.PageObject;
import org.junit.Assert;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class HomePage extends PageObject {

    public void userIsOnTheGoogleFlightSearchWebsite() {
        assertThat(getDriver().getTitle(), containsString("Google Flights"));
    }
}
