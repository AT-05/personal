package at05ui.steps;

import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.ui.EditPersonalInfoPage;
import at05ui.sampleapp.ui.IdentifyPage;
import at05ui.sampleapp.ui.IndexPage;
import at05ui.sampleapp.ui.LoginPage;
import at05ui.sampleapp.ui.MyAccountPage;
import at05ui.sampleapp.ui.PageTransporter;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class EditPersonalInfo {

  private IndexPage indexPage;
  private LoginPage loginPage;
  private MyAccountPage myAccountPage;
  private EditPersonalInfoPage editPersonalInfoPage;
  private IdentifyPage identifyPage;

  @Given("^I navigate to login page and Sing In  with email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void iNavigateToLoginPageAndSingInWithEmailAndPassword(String email, String pass) {
    indexPage = PageTransporter.getInstance().navigateToIndexPage();
    loginPage = indexPage.clickSingIn();
    myAccountPage = loginPage.insertUser(email, pass);

  }

  @When("^I do click in Edit Personal Info$")
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

  @Then("^should be displayedIdentify page$")
  public void shouldBeDisplayedMyAccountPageWithMyInformationChange() {
    assertTrue(identifyPage.IAmInIdentifyPage());
  }


}
