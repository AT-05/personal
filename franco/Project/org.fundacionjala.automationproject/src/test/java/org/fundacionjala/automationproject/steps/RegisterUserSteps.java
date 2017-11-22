package org.fundacionjala.automationproject.steps;

import org.fundacionjala.automationproject.entities.UserInfo;
import static org.junit.Assert.assertTrue;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;
import org.fundacionjala.automationproject.ui.MainPage;
import org.fundacionjala.automationproject.ui.PageTransporter;
import org.fundacionjala.automationproject.ui.UserConfirmationPage;
import org.fundacionjala.automationproject.ui.UserRegistrationPage;

/**
 * Created by Franco Aldunate on 11/21/2017.
 */
public class RegisterUserSteps {
  private final PageTransporter pageTransporter;
  private MainPage mainPage;
  private UserRegistrationPage userRegistrationPage;
  private UserConfirmationPage userConfirmationPage;
  private final UserInfo userInfo;

  /**
   * <p>This constructor gets page transporter instance
   * and receives an entity class.</p>
   *
   * @param userInfo is an entity class.
   */
  public RegisterUserSteps(UserInfo userInfo) {
    pageTransporter = PageTransporter.getInstance();
    this.userInfo = userInfo;
  }

  /**
   * <p>This method navigates to main page
   * and sends to registration page.</p>
   */
  @Given("^I navigate to Registration Page$")
  public void iNavigateToRegistrationPage() {
    mainPage = pageTransporter.getMainPage();
    userRegistrationPage = mainPage.goToRegistrationPage();
  }

  /**
   * <p>This method navigates to main page.</p>
   *
   * @param userInfoTable is a DataTable object type.
   */
  @When("^I fill user info with$")
  public void iFillUserInfoWith(DataTable userInfoTable) {
    Map<String, String> userInfoMap = userInfoTable.asMap(String.class, String.class);
    userInfo.setUserInfo(userInfoMap);
    userConfirmationPage = userRegistrationPage.registerUser(userInfo.getUserInfo());
  }

  /**
   * <p>This method checks for user confirmation message compliance.</p>
   */
  @Then("^I should see a user registered confirmation message$")
  public void iShouldSeeAUserRegisteredConfirmationMessage() {
    assertTrue(userConfirmationPage.confirmationMessageIsDisplayed(userInfo));
  }
}
