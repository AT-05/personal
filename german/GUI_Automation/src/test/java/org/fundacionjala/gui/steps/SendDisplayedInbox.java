package org.fundacionjala.gui.steps;

import org.fundacionjala.gui.mailapp.Entities.Mail;
import org.fundacionjala.gui.mailapp.ui.InboxPage;
import org.fundacionjala.gui.mailapp.ui.LoginPage;
import org.fundacionjala.gui.mailapp.ui.NextPage;
import org.fundacionjala.gui.mailapp.ui.PageTransporter;
import cucumber.api.java.en.Then;

/**
 * Created by Administrator on 11/22/2017.
 */
public class SendDisplayedInbox {
  LoginPage loginPage;
  InboxPage inboxPage;
  NextPage nextPage;
  Mail mail;

  public SendDisplayedInbox(Mail mail) {
    this.mail = mail;
  }

  @Then("^the email send should be displayed in the Inbox list$")
  public void displayedInbox() throws Throwable {
    //inboxPage.searchMail();
    //inboxPage.deleteMailBySubject("AT05");
    //Thread.sleep(3000);
    inboxPage = PageTransporter.getInstance().navigateToInboxPage();
    inboxPage.containMailWithSubject(mail.getSubject());
  }

}
