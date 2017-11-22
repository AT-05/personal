package at05ui.steps;

import at05ui.sampleapp.Entities.Mail;
import at05ui.sampleapp.ui.InboxPage;
import at05ui.sampleapp.ui.LoginPage;
import at05ui.sampleapp.ui.NextPage;
import at05ui.sampleapp.ui.PageTransporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;

/**
 * Created by Administrator on 11/20/2017.
 */
public class SendStep {
  LoginPage loginPage;
  InboxPage inboxPage;
  NextPage nextPage;
  Mail mail;

  public SendStep(Mail mail) {
    this.mail = mail;
    this.mail.setBody("this is a mail");
    //this.mail.setSubject("AT05GUI");
    this.mail.setTo("german.eduardo.qm@gmail.com");
  }

  @When("^I go to the Inbox page")
  public void fillFieldIdentifier() throws InterruptedException {
    inboxPage = PageTransporter.getInstance().navigateToInboxPage();
  }

  @And("^I sent a new for to me with the following subject :\"AT05GUI\"$")
  public void sendMail() throws InterruptedException {
    inboxPage.waitPageIsLoaded();
    this.mail.setSubject("AT05GUI");
    //
    inboxPage.sendMail(mail.getTo(), mail.getSubject(), mail.getBody());
    Thread.sleep(3000);
  }
/*  @Then("^the email send should be displayed in the Inbox list$")
  public void displayedInbox() throws Throwable {
      //inboxPage.searchMail();
    //inboxPage.deleteMailBySubject("AT05");
    //Thread.sleep(3000);
    inboxPage.containMailWithSubject("AT05GUI");
  }*/

}
