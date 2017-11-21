package at05ui.steps;

import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.ui.AuthenticationPage;
import at05ui.sampleapp.ui.CreateAccountPage;
import at05ui.sampleapp.ui.PageTransporter;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;

public class AuthenticationStep {

  private AuthenticationPage authenticationPage;
  private CreateAccountPage createAccountPage;

  /**
   * Navigate to CreateAccountPage.
   */
  @Given("^I navigate to MainPage$")
  public void navigateToCreateAccount() {
    authenticationPage = PageTransporter.getInstance().navigateToMainPage();

  }


  @When("^I put the new email$")
  public void iPutTheNewEmail(DataTable table) {
    List<List<String>> data = table.raw();
    createAccountPage = authenticationPage.setNewAccount(data.get(0).get(1).toString());
  }

  @Then("^should be displayed create page$")
  public void shouldBeCreatePageDisplayed() {

    assertTrue(createAccountPage.IAmCreateAccountPage());


  }


}
