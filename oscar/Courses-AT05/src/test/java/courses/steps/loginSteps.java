package courses.steps;

import static org.testng.Assert.assertTrue;

import courses.sampleapp.entities.User;
import courses.sampleapp.ui.HomePage;
import courses.sampleapp.ui.LoginPage;
import courses.sampleapp.ui.PageTransporter;
import courses.sampleapp.ui.PrincipalPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Administrator on 11/21/2017.
 */
public class loginSteps {

  private PrincipalPage principalPage;
  private LoginPage loginPage;
  private HomePage homePage;

  private User user;

  public loginSteps(HomePage homePage) {
    this.homePage = homePage;
  }

  @Given("^I navigate to Login page$")
  public void navigateToLoginPage() {
    principalPage = PageTransporter.getInstance().navigateToPrincipalPage();
    loginPage = principalPage.goToLoginPage();
  }

  @When("^I login with name \"([^\"]*)\", last name \"([^\"]*)\", email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void iLoginWithNameLastNameEmailAndPassword(String firstName, String lastName,
      String email,
      String password) {
    user = new User(firstName, lastName, email, password);
    homePage = loginPage.enterCredentials(user);
  }

  @Then("^the Home page should be displayed$")
  public void theHomePageShouldBeDisplayed() {
    assertTrue(homePage.isInTheHomePage(), "Home page is displayed.");
  }
}
