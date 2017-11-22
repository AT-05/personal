package at05ui.steps;

import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.ui.AuthenticationPage;
import at05ui.sampleapp.ui.CreateAccountPage;
import at05ui.sampleapp.ui.LoginPage;
import at05ui.sampleapp.ui.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Class step createAccount.
 */
public class CreateAccountStep {

  private AuthenticationPage authenticationPage;
  private CreateAccountPage createAccountPage;
  private MyAccountPage myAccountPage;

  private LoginPage loginPage;

  /**
   * Constructor loginPage.
   *
   * @param loginPage class login.
   */
  public CreateAccountStep(LoginPage loginPage) {
    this.loginPage = loginPage;
  }


  @And("^I authenticate new email\"([^\"]*)\"$")
  public void iAuthenticateNewEmail(String email) {
    authenticationPage = loginPage.goToAuthenticationPage();
    createAccountPage = authenticationPage.setNewAccount(email);
  }

  @When("^I create a new Account with the following personal information \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and also \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
  public void iCreateANewAccountWithTheFollowingInformationAnd(String firstName, String lastName,
      String email, String password, int day, int month, String year) {
    createAccountPage
        .setYourPersonalInformation(firstName, lastName, email, password, day, month, year);
  }

  @And("^also with the following address information \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and also \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
  public void alsoWithTheFollowingAddressInformationAndAlso(String firsNameAddress,
      String lastNameAddress, String company, String address, String city, int state,
      String postalCode, String country, String phone) {
    createAccountPage
        .setYourAddress(firsNameAddress, lastNameAddress, company, address, city, state, postalCode,
            country, phone);
    myAccountPage = createAccountPage.clickRegister();
  }

  @Then("^should be displayed Home page$")
  public void shouldBeHomePageDisplayed() {
    assertTrue(myAccountPage.IAmMyAccount());

  }


}
