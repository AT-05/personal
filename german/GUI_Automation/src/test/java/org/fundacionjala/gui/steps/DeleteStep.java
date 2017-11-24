package org.fundacionjala.gui.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.gui.mailapp.Entities.Mail;
import org.fundacionjala.gui.mailapp.ui.InboxPage;
import org.fundacionjala.gui.mailapp.ui.PageTransporter;

/**
 * Created by German on 11/21/2017.
 */
public class DeleteStep {

  private InboxPage inboxPage;
  private Mail mail;

  /**
   * <p>This constructor receive a Mail instance.</p>
   *
   * @param mail is a Mail instance
   */
  public DeleteStep(Mail mail) {
    this.mail = mail;
  }



  @Given("^I have a email received$")
  public void inboxAccount() {
    inboxPage = PageTransporter.getInstance().navigateToInboxPage();
  }

  @When("^I go to the Inbox received page")
  public void selectMail() {
    inboxPage = PageTransporter.getInstance().navigateToInboxPage();
  }

  @And("^I delete the email with subject \"AT05GUI\"$")
  public void deleteMail() {
    inboxPage.deleteMailBySubject("AT05GUI");
  }

  @Then("^the email be removed from the Inbox email list$")
  public void deleteShow() {
    inboxPage.waitPageIsLoaded();
    inboxPage.containMailWithSubject("AT05GUI");

  }


}
