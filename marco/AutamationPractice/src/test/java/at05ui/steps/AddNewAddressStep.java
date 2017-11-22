package at05ui.steps;

import static org.testng.Assert.assertTrue;

import at05ui.sampleapp.ui.AddNewAddressPage;
import at05ui.sampleapp.ui.MyAccountPage;
import at05ui.sampleapp.ui.MyAddressPage;
import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.Map;

public class AddNewAddressStep {

  private MyAccountPage myAccountPage;
  private MyAddressPage myAddressPage;
  private AddNewAddressPage addNewAddressPage;

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
    //   List<List<String>> data = table.raw();
   /* addNewAddressPage.setNewAddress(data.get(0).get(1).toString(), data.get(1).get(1).toString(),
        data.get(2).get(1).toString(), data.get(3).get(1).toString(), data.get(4).get(1).toString(),
        Integer.parseInt(data.get(5).get(1).toString()), data.get(6).get(1).toString(),
        data.get(7).get(1).toString(), data.get(8).get(1).toString(), data.get(9).get(1).toString(),
        data.get(10).get(1).toString());
*/
    Map<String, String> map = table.asMap(String.class, String.class);
    String firstName = map.get("firstName");
    String lastName = map.get("lastName");
    String company = map.get("company");
    String address = map.get("address");
    String city = map.get("city");
    int state = Integer.parseInt(map.get("state"));
    String postal = map.get("postal");
    String country = map.get("country");
    String phoneHome = map.get("phoneHome");
    String phoneMobile = map.get("phoneMobile");
    String alias = map.get("alias");

    addNewAddressPage
        .setNewAddress(firstName, lastName, company, address, city, state, postal, country,
            phoneHome, phoneMobile, alias);

    myAddressPage = addNewAddressPage.clickBtnSave();
  }

  @Then("^should be displayed My Address page$")
  public void shouldBeDisplayedMyAddressPage() {
    assertTrue(myAddressPage.IAmMyAccount());
  }
  @After(value = "@AddNewAddress", order = 999)
  public void logout() {
    myAddressPage.clickLogOut();
  }

}
