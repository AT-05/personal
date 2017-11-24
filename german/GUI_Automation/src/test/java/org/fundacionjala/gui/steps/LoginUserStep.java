package org.fundacionjala.gui.steps;


import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.gui.mailapp.config.SampleAppEnvsConfig;
import org.fundacionjala.gui.mailapp.ui.InboxPage;
import org.fundacionjala.gui.mailapp.ui.LoginPage;
import org.fundacionjala.gui.mailapp.ui.NextPage;
import org.fundacionjala.gui.mailapp.ui.PageTransporter;

import static org.testng.Assert.assertTrue;

/**
 * Created by German on 11/21/2017.
 */

public class LoginUserStep {

  LoginPage loginPage;
  InboxPage inboxPage;
  NextPage nextPage;

  /**
   * <p>This method step navigates to login page.</p>
   */
  @Given("^google mail page opened$")
  public void navigateToLoginAccount() {
    loginPage = PageTransporter.getInstance().navigateToLoginPage();

  }

  /**
   * <p>This method logs in the user into the application.</p>
   *
   * @param email    is the given user name.
   * @param password is the given user password.
   */
  @When("^I fill the field email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void loginWithIdentifier(String email, String password) throws InterruptedException {
    nextPage = loginPage.loginIdentifier(email);
    inboxPage = nextPage.nextPassword(SampleAppEnvsConfig.getInstance().getUserPassword());

  }

  /**
   * <p>This method check if My Inbox page displayed  .</p>
   */
  @Then("^should be displayed My Inbox page$")
  public void inboxAccount() throws Throwable {
    assertTrue(inboxPage.isInboxPage());
  }

  /**
   * <p>This method check if  the user is logged .</p>
   */
  @Given("^I am logged to google mail$")
  public void iAmLoggedToGoogleMail() throws Throwable {
    if (!PageTransporter.getInstance().isOnInbox()) {      //if the user is logged
      navigateToLoginAccount();
      loginWithIdentifier(SampleAppEnvsConfig.getInstance().getUserName(), SampleAppEnvsConfig.getInstance().getUserPassword());
    }
  }

  /**
   * <p>This method is executed after login  .</p>
   */
  @After(value = "@Logout", order = 999)
  public void afterLoginScenario() throws InterruptedException {
    //log.info("After hook @Logout");
    logOut();
  }

  /**
   * <p>This method logout the user .</p>
   */
  public void logOut() throws InterruptedException {
    inboxPage.logout();
    Thread.sleep(3000);

  }
}
