package at05ui.steps;

import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.ui.AuthenticationPage;
import at05ui.sampleapp.ui.CreateAccountPage;
import at05ui.sampleapp.ui.MyAccountPage;
import at05ui.sampleapp.ui.PageTransporter;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAccountStep {

  private AuthenticationPage authenticationPage;
  private CreateAccountPage createAccountPage;
  private MyAccountPage myAccountPage;

  @Given("^I navigate to MainPage and put new email\"([^\"]*)\"$")
  public void iNavigateToMainPageAndPushNewEmail(String email) {
    authenticationPage = PageTransporter.getInstance().navigateToMainPage();
    createAccountPage = authenticationPage.setNewAccount(email);
  }

  @When("^I create a new Account with the following personal information \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and also \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
  public void iCreateANewAccountWithTheFollowingInformationAnd(String firstName, String lastName,
      String email, String password, int day, int month, String year)  {
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

  @After(value = "@CreateAccount", order = 999)
  public void logout() {
    myAccountPage.clickLogOut();
  }


}
