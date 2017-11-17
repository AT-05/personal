package at05ui.steps;

import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.ui.IndexPage;
import at05ui.sampleapp.ui.LoginPage;
import at05ui.sampleapp.ui.PageTransporter;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IndexPageStep {

  private IndexPage indexPage;
  private LoginPage loginPag;

  @Given("^I navigate to Index Page$")
  public void navigateToIndexPage() {
    indexPage = PageTransporter.getInstance().navigateToIndexPage();
  }

  @When("^I press the option Sign In$")
  public void iPressTheOptionSignIn() throws Throwable {
    loginPag = indexPage.clickSingIn();
  }

  @Then("^should be displayed Login page$")
  public void shouldBeDisplayedLoginPage() throws Throwable {
    assertTrue(loginPag.IsAmInLoginPage());

  }
}
