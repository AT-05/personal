package at05ui.steps;

import at05ui.sampleapp.Entities.Mail;
import at05ui.sampleapp.ui.InboxPage;
import at05ui.sampleapp.ui.LoginPage;
import at05ui.sampleapp.ui.NextPage;
import at05ui.sampleapp.ui.PageTransporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Administrator on 11/21/2017.
 */
public class DeleteStep {
  LoginPage loginPage;
  InboxPage inboxPage;
  NextPage nextPage;
  private Mail mail;

  public DeleteStep(Mail mail) {
    this.mail = mail;
  }

  @Given("^I have a email received$")
  public void inboxAccount() throws Throwable {
    inboxPage = PageTransporter.getInstance().navigateToInboxPage();
  }

  @When("^I go to the Inbox received page")
  public void selectMail() throws InterruptedException {
    inboxPage = PageTransporter.getInstance().navigateToInboxPage();
  }

  @And("^I delete the email with subject \"AT05GUI\"$")
  public void deleteMail() throws InterruptedException {
    inboxPage.deleteMailBySubject("AT05GUI");
  }

  @Then("^the email be removed from the Inbox email list$")
  public void deleteShow() throws Throwable {
    inboxPage.waitPageIsLoaded();
    inboxPage.containMailWithSubject("AT05GUI");
    Thread.sleep(3000);
  }


}
