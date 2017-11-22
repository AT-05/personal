package at05ui.steps;


import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.ui.LoginPage;
import at05ui.sampleapp.ui.MyAccountPage;
import at05ui.sampleapp.ui.PageTransporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Class step loginUser.
 */
public class LoginUserStep {

  private LoginPage loginPage;
  private MyAccountPage myAccountPage;

  @Given("^I navigate to login page$")
  public void navigateToCreateAccount() {
    loginPage = PageTransporter.getInstance().navigateToLoginPage();


  }

  @When("^I fill the field email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void fillFieldPersonalInformation(String email, String password) {
    myAccountPage = loginPage.setLogin(email, password);
  }

  @Then("^should be displayed My Account page$")
  public void createANewAccount() {
    assertTrue(myAccountPage.IAmMyAccount());
  }


}
