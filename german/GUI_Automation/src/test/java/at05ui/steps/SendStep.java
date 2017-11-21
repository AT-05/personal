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
import cucumber.api.java.en.And;
/**
 * Created by Administrator on 11/20/2017.
 */
public class SendStep {
  LoginPage loginPage;
  InboxPage inboxPage;
  NextPage nextPage;

  @When("^I go to the Inbox page")
  public void fillFieldIdentifier() throws InterruptedException {
    inboxPage=PageTransporter.getInstance().navigateToInboxPage();
  }
  @ And("^I sent a new for to me with the following subject :\"AT05\"$")
  public void sendMail() throws InterruptedException {
    inboxPage.waitPageIsLoaded();
//    inboxPage.clickCompose();
//    inboxPage.clickSend();
//
    inboxPage.sendMail("german.eduardo.qm@gmail.com","AT05","This is my mail");
    Thread.sleep(8000);
  }

    @Then("^the email send should be displayed in the Inbox list$")
  public void inboxAccount() throws Throwable {
    assertTrue(inboxPage.isInboxPage());
  }
}
