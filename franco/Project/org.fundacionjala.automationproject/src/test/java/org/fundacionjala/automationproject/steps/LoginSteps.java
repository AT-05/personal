package org.fundacionjala.automationproject.steps;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.automationproject.automation.Automation;
import org.fundacionjala.automationproject.ui.HomePage;
import org.fundacionjala.automationproject.ui.MainPage;
import org.fundacionjala.automationproject.ui.PageTransporter;
import static org.junit.Assert.assertTrue;

/**
 * Created by Franco Aldunate on 11/15/2017.
 */
public class LoginSteps {
  private final PageTransporter pageTransporter;
  private MainPage mainPage;
  private HomePage homePage;
  private Automation automation;

  /**
   * <p>This constructor gets page transporter instance.</p>
   */
  public LoginSteps() {
    /*try {
      automation = Automation.getInstance();
      automation.startUp();
    } catch (Exception e) {
      e.printStackTrace();
    }*/
    pageTransporter = PageTransporter.getInstance();
  }

  /**
   * <p>This step performs navigation to main page.</p>
   */
  @Given("^I navigate to Main Page$")
  public void iNavigateToMainPage() {
    mainPage = pageTransporter.navigateToMainPage();
  }

  /**
   * <p>This step performs login of user into the application.</p>
   *
   * @param userName is the given user name.
   * @param password is the given user password.
   */
  @When("^I login as \"([^\"]*)\" with password \"([^\"]*)\"$")
  public void iLoginAsWithPassword(String userName, String password) {
    homePage = mainPage.loginUser(userName, password);
  }

  /**
   * <p>This step performs checked of successful user login.</p>
   */
  @Then("^I should be redirected to home page$")
  public void iShouldBeRedirectedToHomePage() {
    assertTrue(homePage.userIsLoggedIn());
  }

  /**
   * <p>This step is executed after loginUser scenario.</p>
   */
  @After(value = "@Login", order = 999)
  public void afterLoginScenario() {
    homePage.logOut();
  }
}
