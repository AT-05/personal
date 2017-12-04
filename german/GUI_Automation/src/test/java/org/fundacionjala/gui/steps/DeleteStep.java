package org.fundacionjala.gui.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.gui.mailapp.Entities.Mail;
import org.fundacionjala.gui.mailapp.config.SampleAppEnvsConfig;
import org.fundacionjala.gui.mailapp.ui.InboxPage;
import org.fundacionjala.gui.mailapp.ui.PageTransporter;

import static org.testng.Assert.assertFalse;

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
    inboxPage = PageTransporter.getInstance().navigateToInboxPage();
  }

  /**
   * <p>This method sends an email .</p>
   *
   * @param subject of the mail
   * @param body    of the mail
   */
  @Given("I send an email to myself under subject \"([^\"]*)\"and body \"([^\"]*)\"$")
  public void sendEmailToMyself(String subject, String body) {
    this.mail.setSubject(subject);
    this.mail.setBody(body);
    this.mail.setTo(SampleAppEnvsConfig.getInstance().getUserName());
    inboxPage.sendMail(this.mail.getTo(), this.mail.getSubject(), this.mail.getBody());
  }

  /**
   * <p>This method step navigates to Inbox page.</p>
   */
  @When("^I go to the Inbox  page")
  public void goToInbox() {
    inboxPage = PageTransporter.getInstance().navigateToInboxPage();
  }

  /**
   * <p>This method deletes an email.</p>
   */
  @And("^I delete this email$")
  public void deleteMail() {
    inboxPage.deleteMailBySubject(this.mail.getSubject());
  }

  /**
   * <p>This method checks an email was removed.</p>
   */
  @Then("^the email should be removed from my Inbox email list$")
  public void deleteShow() {
    inboxPage.waitPageIsLoaded();
    assertFalse(inboxPage.containMailWithSubject(
      this.mail.getSubject()), "No found email");
  }


}
