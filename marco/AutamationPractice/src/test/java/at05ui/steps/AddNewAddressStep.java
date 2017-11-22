package at05ui.steps;

import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.ui.AddNewAddressPage;
import at05ui.sampleapp.ui.MyAccountPage;
import at05ui.sampleapp.ui.MyAddressPage;
import cucumber.api.DataTable;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;

/**
 * Class Add new address step.
 */
public class AddNewAddressStep {

  private MyAccountPage myAccountPage;
  private MyAddressPage myAddressPage;
  private AddNewAddressPage addNewAddressPage;

  /**
   * Constructor where I pass parameter of DI.
   *
   * @param myAccountPage1 class myAccountPage.
   */
  public AddNewAddressStep(MyAccountPage myAccountPage1) {
    myAccountPage = myAccountPage1;
  }

  @When("^I go to Add new Address page$")
  public void iGoToAddNewAddress() {
    myAddressPage = myAccountPage.goToMyAddress();
    addNewAddressPage = myAddressPage.goToAddNewAddress();
  }

  @And("^I add new Address with the following fields$")
  public void iAddNewAddressWithTheFollowingFields(DataTable table) {
    Map<String, String> map = table.asMap(String.class, String.class);
    final String firstName = map.get("firstName");
    final String lastName = map.get("lastName");
    final String company = map.get("company");
    final String address = map.get("address");
    final String city = map.get("city");
    final int state = Integer.parseInt(map.get("state"));
    final String postal = map.get("postal");
    final String country = map.get("country");
    final String phoneHome = map.get("phoneHome");
    final String phoneMobile = map.get("phoneMobile");
    final String alias = map.get("alias");

    addNewAddressPage
        .setNewAddress(firstName, lastName, company, address, city, state, postal, country,
            phoneHome, phoneMobile, alias);

    myAddressPage = addNewAddressPage.clickBtnSave();
  }

  @Then("^should be displayed My Address page$")
  public void shouldBeDisplayedMyAddressPage() {
    assertTrue(myAddressPage.IAmMyAccountPage());
  }


}
