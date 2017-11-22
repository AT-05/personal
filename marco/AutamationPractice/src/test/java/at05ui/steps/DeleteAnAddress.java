package at05ui.steps;

import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.ui.MyAccountPage;
import at05ui.sampleapp.ui.MyAddressPage;
import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteAnAddress {

  private MyAccountPage myAccountPage;
  private MyAddressPage myAddressPage;


  public DeleteAnAddress(MyAccountPage myAccountPage1) {
    myAccountPage = myAccountPage1;

  }

  @When("^I delete an Address$")
  public void iDeleteAnAddress() throws Throwable {
    myAddressPage = myAccountPage.goToMyAddress();
    myAddressPage.deleteAnAddress();
  }

  @Then("^should be displayed Actualize My Address page$")
  public void shouldBeDisplayedActualizeMyAddressPage()  {
    assertTrue(myAddressPage.deleteAddress());
  }
  @After(value = "@DeleteAddress", order = 999)
  public void logout() {
    myAddressPage.clickLogOut();
  }

}
