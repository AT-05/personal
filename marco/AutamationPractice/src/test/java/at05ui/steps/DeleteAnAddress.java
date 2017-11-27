package at05ui.steps;

import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.config.SampleAppEnvsConfig;
import at05ui.sampleapp.ui.LoginPage;
import at05ui.sampleapp.ui.MyAccountPage;
import at05ui.sampleapp.ui.MyAddressPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Step Class DeleteAnAddress.
 */
public class DeleteAnAddress {

  private LoginPage loginPage;
  private MyAccountPage myAccountPage;
  private MyAddressPage myAddressPage;

  /**
   * Constructor where pass parameter using DI.
   *
   * @param myAccountPage1 class MyAccountPage.
   */
  public DeleteAnAddress(MyAccountPage myAccountPage1, LoginPage loginPage) {
    myAccountPage = myAccountPage1;
    this.loginPage = loginPage;

  }

  @When("^I select Delete an Address option$")
  public void iSelectDeleteAnAddress() {
    myAddressPage = myAccountPage.goToMyAddress();

  }

  @And("^I delete an address$")
  public void iDeleteAnAddress() {
    myAddressPage.deleteAnAddress();
  }

  @Then("^should be displayed Actualize My Address page$")
  public void shouldBeDisplayedActualizeMyAddressPage() {
    assertTrue(myAddressPage.IsRemovedAddress());
  }


  @And("^I logIn with email  and password$")
  public void iLogInWithEmailAndPassword() {
    final String email = SampleAppEnvsConfig.getInstance().getUserName();
    final String pass = SampleAppEnvsConfig.getInstance().getUserPassword();
    myAccountPage = loginPage.setLogin(email, pass);
  }
}
