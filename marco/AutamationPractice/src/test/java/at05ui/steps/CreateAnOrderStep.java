package at05ui.steps;

import at05ui.sampleapp.ui.MyAccountPage;
import at05ui.sampleapp.ui.MyOrderPage;
import at05ui.sampleapp.ui.SearchPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAnOrderStep {

  private MyAccountPage myAccountPage;
  private MyOrderPage myOrderPage;
  private SearchPage searchPage;

  public CreateAnOrderStep(MyAccountPage myAccountPage) {
    this.myAccountPage = myAccountPage;
  }

  @When("^I search an product\"([^\"]*)\"$")
  public void iSearchAnProduct(String product) throws Throwable {
    myOrderPage = myAccountPage.goToMyOrderPage();
    searchPage = myOrderPage.searchProduct(product);
  }

  @And("^I select a items$")
  public void iSelectAItems() throws Throwable {
    searchPage.clickBtnAdd();

  }

  @Then("^should be displayed$")
  public void shouldBeDisplayed() throws Throwable {

  }
}
