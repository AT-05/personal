package org.fundacionjala.gui.steps;

import cucumber.api.java.en.Then;
import org.fundacionjala.gui.mailapp.Entities.Mail;
import org.fundacionjala.gui.mailapp.ui.InboxPage;
import org.fundacionjala.gui.mailapp.ui.PageTransporter;

/**
 * Created by German on 11/22/2017.
 */
public class DisplayInbox {

  private InboxPage inboxPage;
  private Mail mail;

  /**
   * <p>This constructor receive a Mail instance.</p>
   *
   * @param mail is a Mail instance
   */
  public DisplayInbox(Mail mail) {
    this.mail = mail;
  }

  /**
   * <p>This method checks an email on inbox has a specific subject.</p>
   */
  @Then("^the email should be displayed in My Inbox list$")
  public void displayInbox() {
    inboxPage = PageTransporter.getInstance().navigateToInboxPage();
    inboxPage.containMailWithSubject(mail.getSubject());
  }


}
