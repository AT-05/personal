package at05outlook.hooks;

import at05outlook.sampleapp.ui.HomePage;
import cucumber.api.java.After;


/**
 * Management the hooks.
 */
public class Hook {
    private HomePage homePage;

    /**
     * The constructor of object with dependency injection.
     *
     * @param homePage is Page element.
     */
    public Hook(HomePage homePage) {
        this.homePage = homePage;
    }

    /**
     * Log off from the page
     */
    @After(value = "@LogOut", order = 999)
    public void afterLoginScenario() {
        try {
            homePage.logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
