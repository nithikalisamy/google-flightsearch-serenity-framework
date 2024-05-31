package superchoice;

import net.serenitybdd.annotations.Step;
import superchoice.pages.HomePage;

public class HomePageSteps {
    HomePage homePage;

    @Step
    public void userIsOnTheGoogleFlightSearchWebsite() {
        homePage.open();
        homePage.userIsOnTheGoogleFlightSearchWebsite();
    }
}
