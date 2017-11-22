package at05ui.steps;


import at05ui.sampleapp.config.SampleAppEnvsConfig;
import at05ui.sampleapp.ui.InboxPage;
import at05ui.sampleapp.ui.LoginPage;
import at05ui.sampleapp.ui.NextPage;
import at05ui.sampleapp.ui.PageTransporter;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.testng.Assert.assertTrue;

public class LoginUserStep {

  LoginPage loginPage;
  InboxPage inboxPage;
  NextPage nextPage;

  @Given("^google mail page opened$")
  public void navigateToLoginAccount() {
    loginPage = PageTransporter.getInstance().navigateToLoginPage();

  }

  @When("^I fill the field email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void loginWithIdentifier(String email, String password) throws InterruptedException {
    nextPage = loginPage.loginIdentifier(email);
    inboxPage = nextPage.nextPassword(SampleAppEnvsConfig.getInstance().getUserPassword());

  }

  @Then("^should be displayed My Inbox page$")
  public void inboxAccount() throws Throwable {
    assertTrue(inboxPage.isInboxPage());
  }

  @Given("^I am logged to google mail$")
  public void iAmLoggedToGoogleMail() throws Throwable {
    if (!PageTransporter.getInstance().isOnInbox()) {      //if the user is logged
      navigateToLoginAccount();
      loginWithIdentifier(SampleAppEnvsConfig.getInstance().getUserName(), SampleAppEnvsConfig.getInstance().getUserPassword());
    }
  }

  @After(value = "@Logout", order = 999)
  public void afterLoginScenario() throws InterruptedException {
    //log.info("After hook @Logout");
    logOut();
  }

  public void logOut() throws InterruptedException {
    inboxPage.logout();
    Thread.sleep(3000);

  }
}
