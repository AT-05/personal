package at05ui.steps;


import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.config.SampleAppEnvsConfig;
import at05ui.sampleapp.ui.InboxPage;
import at05ui.sampleapp.ui.LoginPage;
import at05ui.sampleapp.ui.NextPage;
import at05ui.sampleapp.ui.PageTransporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginUserStep {

  LoginPage loginPage;
  InboxPage inboxPage;
  NextPage nextPage;

  @Given("^google mail page opened$")
  public void navigateToCreateAccount() {
    loginPage = PageTransporter.getInstance().navigateToLoginPage();

  }
  @When("^I fill the field email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void fillFieldIdentifier(String email, String password) throws InterruptedException {
    nextPage = loginPage. loginIdentifier(email);
    inboxPage =nextPage.nextPassword(SampleAppEnvsConfig.getInstance().getUserPassword());

  }

  @Then("^should be displayed My Inbox page$")
  public void inboxAccount() throws Throwable {
    assertTrue(inboxPage.isInboxPage());
  }
}
