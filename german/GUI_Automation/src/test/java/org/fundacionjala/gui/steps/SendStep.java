package org.fundacionjala.gui.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fundacionjala.gui.mailapp.Entities.Mail;
import org.fundacionjala.gui.mailapp.config.SampleAppEnvsConfig;
import org.fundacionjala.gui.mailapp.ui.InboxPage;
import org.fundacionjala.gui.mailapp.ui.PageTransporter;

/**
 * Created by German on 11/20/2017.
 */
public class SendStep {
  private static final int ORDER = 999;
  private InboxPage inboxPage;
  private Mail mail;

  /**
   * <p>This constructor receive a Mail instance.</p>
   *
   * @param mail is a Mail instance
   */
  public SendStep(Mail mail) {
    this.mail = mail;
  }

  /**
   * <p>This method step navigates to Inbox page.</p>
   */
  @When("^I go to the Inbox page")
  public void goToInbox() {
    inboxPage = PageTransporter.getInstance().navigateToInboxPage();
  }

  /**
   * <p>This method sends an email .</p>
   *
   * @param subject of the mail
   * @param body    of the mail
   * @throws InterruptedException instance.
   */
  @And("^I send an email to myself under the following subject \"([^\"]*)\" and body \"([^\"]*)\"$")
  public void sendMail(String subject, String body) throws InterruptedException {
    this.mail.setTo(SampleAppEnvsConfig.getInstance().getUserName());
    this.mail.setSubject(subject);
    this.mail.setBody(body);
    sendMail(this.mail);
  }

  /**
   * <p>This method sends an email .</p>
   *
   * @param mail is a Mail instance
   */
  public void sendMail(Mail mail) {
    inboxPage.waitPageIsLoaded();
    inboxPage.sendMail(mail.getTo(), mail.getSubject(), mail.getBody());
  }

  /**
   * <p>This method is executed after Send email  .</p>
   */
  @After(value = "@SendEmail", order = ORDER)
  public void afterSendMessageScenario() {
    goToInbox();
    inboxPage.deleteMailBySubject(this.mail.getSubject());
  }

}
