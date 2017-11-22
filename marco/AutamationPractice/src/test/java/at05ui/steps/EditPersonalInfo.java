package at05ui.steps;

import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.ui.EditPersonalInfoPage;
import at05ui.sampleapp.ui.IdentifyPage;
import at05ui.sampleapp.ui.LoginPage;
import at05ui.sampleapp.ui.MyAccountPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Class step EditPersonalInfo.
 */
public class EditPersonalInfo {

  private LoginPage loginPage;
  private MyAccountPage myAccountPage;
  private EditPersonalInfoPage editPersonalInfoPage;
  private IdentifyPage identifyPage;

  public EditPersonalInfo(LoginPage loginPage) {
    this.loginPage = loginPage;

  }

  @And("^I logIn with email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void iRegisterWithEmailAndPassword(String email, String pass) {
    myAccountPage = loginPage.setLogin(email, pass);
  }

  @When("^I go to  Edit Personal Info$")
  public void iDoClickInEditPersonalInfo() {
    editPersonalInfoPage = myAccountPage.clickEditPersonalInfo();
  }


  @And("^I edit my information with\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\"$")
  public void iEditMyInformationWith(String firstName, String lastName, String oldPass, String pass,
      String confirmation, int dia, int month, String year) {
    editPersonalInfoPage
        .setNewInfo(firstName, lastName, oldPass, pass, confirmation, dia, month, year);
    identifyPage = editPersonalInfoPage.clickSave();
  }

  @Then("^should be displayed Identify page$")
  public void shouldBeDisplayedMyAccountPageWithMyInformationChange() {
    assertTrue(identifyPage.IAmInIdentifyPage());
  }


}
