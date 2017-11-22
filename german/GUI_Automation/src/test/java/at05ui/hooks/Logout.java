package at05ui.hooks;

import at05ui.sampleapp.ui.InboxPage;
import at05ui.sampleapp.ui.LoginPage;
import at05ui.sampleapp.ui.NextPage;
import at05ui.sampleapp.ui.PageTransporter;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;

/**
 * Created by Administrator on 11/22/2017.
 */
public class Logout {
  LoginPage loginPage;
  InboxPage inboxPage;
  NextPage nextPage;


//  public void logOut() {
//    inboxPage=PageTransporter.getInstance().navigateToInboxPage();
//
//
//  }
//  //****************************************************************
//  //Hooks for @Logout scenarios
//  //****************************************************************
//
//  @After(value = "@Logout", order = 999)
//  public void afterLoginScenario() {
//    // log.info("After hook @Logout");
//    logOut();
//  }
}
