package at05ui.steps;

import at05ui.sampleapp.Entities.Mail;
import at05ui.sampleapp.ui.InboxPage;
import at05ui.sampleapp.ui.LoginPage;
import at05ui.sampleapp.ui.NextPage;
import at05ui.sampleapp.ui.PageTransporter;
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
