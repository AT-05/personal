package org.fundacionjala.gui.steps;

import org.fundacionjala.gui.mailapp.Entities.Mail;
import org.fundacionjala.gui.mailapp.ui.InboxPage;
import org.fundacionjala.gui.mailapp.ui.LoginPage;
import org.fundacionjala.gui.mailapp.ui.NextPage;
import org.fundacionjala.gui.mailapp.ui.PageTransporter;
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


}
