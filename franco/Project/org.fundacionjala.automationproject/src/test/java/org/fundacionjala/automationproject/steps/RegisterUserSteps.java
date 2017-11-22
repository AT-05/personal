package org.fundacionjala.automationproject.steps;

import org.fundacionjala.automationproject.entities.*;
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
   * <p>This constructor gets page transporter instance.</p>
   */
  public RegisterUserSteps(UserInfo userInfo) {
    pageTransporter = PageTransporter.getInstance();
    this.userInfo = userInfo;
  }

  @Given("^I navigate to Registration Page$")
  public void iNavigateToRegistrationPage() {
    mainPage = pageTransporter.getMainPage();
    userRegistrationPage = mainPage.goToRegistrationPage();
  }

  @When("^I fill user info with$")
  public void iFillUserInfoWith(DataTable userInfoTable) {
    Map<String, String> userInfoMap = userInfoTable.asMap(String.class, String.class);
    userRegistrationPage.fillUserContactInfoForm(userInfoMap);
    userRegistrationPage.fillUserMailingInfoForm(userInfoMap);
    userRegistrationPage.fillUserInfoForm(userInfoMap);
    userInfo.setUserInfo(userInfoMap);
  }

  @Then("^I should see a user registered confirmation message$")
  public void iShouldSeeAUserRegisteredConfirmationMessage() {
    userConfirmationPage = userRegistrationPage.registerUser();
    assertTrue(userConfirmationPage.confirmationMessageIsDisplayed(userInfo));
  }
}
