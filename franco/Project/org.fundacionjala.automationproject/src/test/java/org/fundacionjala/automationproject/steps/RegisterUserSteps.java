package org.fundacionjala.automationproject.steps;

import static org.junit.Assert.assertTrue;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.automationproject.entities.User;
import org.fundacionjala.automationproject.ui.MainPage;
import org.fundacionjala.automationproject.ui.PageTransporter;
import org.fundacionjala.automationproject.ui.UserConfirmationPage;
import org.fundacionjala.automationproject.ui.UserRegistrationPage;
import java.util.List;

/**
 * Created by Franco Aldunate on 11/21/2017.
 */
public class RegisterUserSteps {
  private final PageTransporter pageTransporter;
  private MainPage mainPage;
  private UserRegistrationPage userRegistrationPage;
  private UserConfirmationPage userConfirmationPage;
  private List<User> user;

  /**
   * <p>This constructor gets page transporter instance.</p>
   */
  public RegisterUserSteps() {
    pageTransporter = PageTransporter.getInstance();
  }

  /**
   * <p>This step performs navigation to registration page.</p>
   */
  @Given("^I select Registration option in Menu")
  public void iNavigateToRegistrationPage() {
    mainPage = new MainPage();
    userRegistrationPage = mainPage.goToRegistrationPage();
  }

  /**
   * <p>This step performs registering of user.</p>
   *
   * @param userList is a list of User entity object type.
   */
  @When("^I register a user with the following information$")
  public void iFillUserInfoWith(List<User> userList) {
    this.user = userList;
    userConfirmationPage = userRegistrationPage.registerUser(user);
  }

  /**
   * <p>This step performs checking of user confirmation message compliance.</p>
   */
  @Then("^I should see a user registered confirmation message$")
  public void iShouldSeeAUserRegisteredConfirmationMessage() {
    assertTrue(userConfirmationPage.confirmationMessageIsDisplayed(user));
  }
}
