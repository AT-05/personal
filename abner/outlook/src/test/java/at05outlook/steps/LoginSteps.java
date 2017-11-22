package at05outlook.steps;

import at05outlook.sampleapp.config.SampleAppEnvsConfig;
import at05outlook.sampleapp.ui.HomePage;
import at05outlook.sampleapp.ui.LoginPage;
import at05outlook.sampleapp.ui.Transporter;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

public class LoginSteps {
    private Transporter transporter;
    private LoginPage loginPage;
    private HomePage homePage;




    public LoginSteps(HomePage homePage) throws Exception {
        transporter = Transporter.getInstance();
        this.homePage=homePage;

    }


    @Given("^I navigate to Login page$")
    public void navigateToLoginPage() {
            loginPage = transporter.navigateToLoginPage();
    }

    @When("^I enter correct credentials, as user \"(.*?)\" and password \"(.*?)\"$")
    public void navigateToHomePage(String name, String password) throws InterruptedException {
        homePage = loginPage.login(name, password);
    }

    @Then("^The inbox mail is open$")
    public void inboxMailIsOpen() throws Exception {
        assertTrue(homePage.isLoadPage(), "User displayed in Web");

    }


    @When("^I register whit my account$")
    public void registerWhitMyAccount() throws InterruptedException {
        if (!(loginPage == null)) {
            homePage = loginPage.login(SampleAppEnvsConfig.getInstance().getUserName(), SampleAppEnvsConfig.getInstance().getUserPassword());
        }
    }


    @After(value = "@LogOut", order = 999)
    public void afterLoginScenario()  {
        System.out.println("****************LogOut***********************");
        try {
            homePage.logOut();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
