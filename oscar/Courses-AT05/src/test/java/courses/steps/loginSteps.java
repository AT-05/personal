package courses.steps;

import static org.testng.Assert.assertTrue;

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

  public loginSteps(HomePage homePage) {
    this.homePage = homePage;
  }

  @Given("^I navigate to Login page$")
  public void navigateToLoginPage() {
    System.out.println("Navigate to login page BEFORE ------------------");
    principalPage = PageTransporter.getInstance().navigateToPrincipalPage();
    loginPage = principalPage.goToLoginPage();
    System.out.println("Navigate to login page AFTER ------------------");
  }

  @When("^I login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void iLoginWithEmailAndPassword(String email, String password) {
    System.out.println("Login page BEFORE ------------------");
    homePage = loginPage.enterCredentials(email, password);
    System.out.println("Login page AFTER ------------------");
  }

  @Then("^the Home page should be displayed$")
  public void theHomePageShouldBeDisplayed() throws Throwable {
    assertTrue(homePage.isInTheMainPage(), "Home page is displayed.");
  }
}
