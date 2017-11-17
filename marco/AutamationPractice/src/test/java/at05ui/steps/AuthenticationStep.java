package at05ui.steps;

import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.ui.CreateAccountPage;
import at05ui.sampleapp.ui.AuthenticationPage;
import at05ui.sampleapp.ui.PageTransporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AuthenticationStep {

  AuthenticationPage authenticationPage;
  CreateAccountPage createAccountPage;

  @Given("^I navigate to MainPage$")
  public void navigateToCreateAccount() {
    authenticationPage = PageTransporter.getInstance().navigateToMainPage();
    ////
  }

  @When("^I put the new email\"([^\"]*)\"$")
  public void iPutTheNewEmail(String email) throws Throwable {
    createAccountPage = authenticationPage.setNewAccount(email);
  }

  @Then("^should be create page displayed$")
  public void shouldBeCreatePageDisplayed() throws Throwable {
  assertTrue(createAccountPage.IAmCreateAccountPage());
  }
}
