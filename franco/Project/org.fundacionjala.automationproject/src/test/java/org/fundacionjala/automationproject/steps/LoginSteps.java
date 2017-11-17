package org.fundacionjala.automationproject.steps;

import cucumber.api.*;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.automationproject.automation.Automation;
import org.fundacionjala.automationproject.ui.HomePage;
import org.fundacionjala.automationproject.ui.LoginPage;
import org.fundacionjala.automationproject.ui.MainPage;
import org.fundacionjala.automationproject.ui.PageTransporter;
import static org.junit.Assert.assertTrue;

public class LoginSteps {
  private PageTransporter pageTransporter;
  private LoginPage loginPage;
  private HomePage homePage;
  private MainPage mainPage;
  private Automation automation;

  public LoginSteps() {
    try {
      automation = Automation.getInstance();
      automation.startUp();
    } catch (Exception e) {
      e.printStackTrace();
    }
    pageTransporter = PageTransporter.getInstance();
  }

  @Given("^I navigate to Login page$")
  public void iNavigateToMainPage() {
    pageTransporter.navigateToMainPage();
  }

  @When("^I login as \"([^\"]*)\" with password \"([^\"]*)\"$")
  public void iLoginAsWithPassword(String arg0, String arg1) {
    loginPage = new LoginPage();
    loginPage.setUserName(arg0);
    loginPage.setPassword(arg1);
    homePage = loginPage.login();
  }

  @Then("^I should login successfully as \"([^\"]*)\"$")
  public void iShouldLoginSuccessfullyTo(String arg0) {
    assertTrue(homePage.isUserNameDisplayed(arg0));
  }
}
