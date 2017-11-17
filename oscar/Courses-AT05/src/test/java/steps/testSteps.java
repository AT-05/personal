package steps;

import static org.testng.Assert.assertTrue;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import sampleapp.ui.HomePage;
import sampleapp.ui.LoginPage;
import sampleapp.ui.PageTransporter;
import sampleapp.ui.PrincipalPage;
import sampleapp.ui.RegisterPage;

public class testSteps {

  PrincipalPage principalPage;
  LoginPage loginPage;
  HomePage homePage;
  RegisterPage registerPage;

  @Given("^I navigate to Login page$")
  public void navigateToLoginPage() {
    principalPage = PageTransporter.getInstance().navigateToPrincipalPage();
    loginPage = principalPage.goToLoginPage();
  }

  /*@When("^I enter correct credentials \"oscar@oscar.com:password123\"$")
  public void enterCredentials() {
    loginPage.enterCredentials(SampleAppEnvsConfig.getInstance().getUserName(),
        SampleAppEnvsConfig.getInstance().getUserPassword());
  }*/
  @When("^I enter email \"(.*?)\" with password \"(.*?)\"$")
  public void enterValidCredentials(String email, String password) {
    homePage = loginPage.enterCredentials(email, password);
  }

  /*@Then("^The Home page should be displayed$")
  public void loginPage() {
  }*/
  @Then("^The Home page should be displayed$")
  public void verifyIsTheHomePageIsDisplayed() {
    assertTrue(homePage.isInTheMainPage(), "Home page is displayed.");
  }


  @And("^I navigate to Register page$")
  public void iNavigateToRegisterPage() {
    registerPage = loginPage.goToRegisterPage();
  }

  @When("^I enter first name \"([^\"]*)\", last name \"([^\"]*)\", email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void iEnterFirstNameLastNameEmailAndPassword(String firstName, String lastName,
      String email, String password) {
    homePage = registerPage.registerUser(firstName, lastName, email, password);
  }
}
