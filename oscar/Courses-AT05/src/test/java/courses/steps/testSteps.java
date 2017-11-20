package courses.steps;

import static org.testng.Assert.assertTrue;

import courses.sampleapp.Classes.User;
import courses.sampleapp.ui.HomePage;
import courses.sampleapp.ui.LoginPage;
import courses.sampleapp.ui.PageTransporter;
import courses.sampleapp.ui.PrincipalPage;
import courses.sampleapp.ui.RegisterPage;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Administrator on 11/20/2017.
 */
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

  @When("^I login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void iLoginWithEmailAndPassword(String email, String password) {
    homePage = loginPage.enterCredentials(email, password);
  }

  @Then("^the Home page should be displayed$")
  public void theHomePageShouldBeDisplayed() throws Throwable {
    assertTrue(homePage.isInTheMainPage(), "Home page is displayed.");
  }

  @And("^I navigate to Register page$")
  public void iNavigateToRegisterPage() {
    registerPage = loginPage.goToRegisterPage();
  }

  @When("^I register with first name \"([^\"]*)\", last name \"([^\"]*)\", email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void iRegisterWithFirstNameLastNameEmailAndPassword(String firstName, String lastName, String email,
      String password) {
    homePage = registerPage.registerUser(firstName, lastName, email, password);
  }

  @When("^I register with first name, last name, email and password$")
  public void iRegisterWithFirstNameLastNameEmailAndPassword() throws Throwable {
    User user = new User();
    homePage = registerPage.registerUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
  }

  //****************************************************************
  //Hooks for @Logout scenarios
  //****************************************************************
    @After(value = "@Logout", order = 999)
    public void afterLoginScenario() {
        System.out.println("\nAfter hook @Logout");
        homePage.logout();
    }


}
