package at05ui.hooks;

import at05ui.sampleapp.ui.IdentifyPage;
import at05ui.sampleapp.ui.MyAccountPage;
import at05ui.sampleapp.ui.MyAddressPage;
import cucumber.api.java.After;

public class hooks {

  private MyAddressPage myAddressPage;
  private MyAccountPage myAccountPage;
  private IdentifyPage identifyPage;

  public hooks(MyAddressPage myAddressPage, MyAccountPage myAccountPage, IdentifyPage identifyPage) {
    this.myAddressPage = myAddressPage;
    this.myAccountPage = myAccountPage;
    this.identifyPage=identifyPage;
  }


  @After(value = "@AddNewAddress", order = 999)
  public void addNewAddressLogout() {
    System.out.println("*****************hello **************");
    myAddressPage.clickLogOut();
    System.out.println("*****************world **************");
  }

  @After(value = "@Login", order = 999)
  public void loginPageLogout() {
    myAccountPage.clickLogOut();
  }

  @After(value = "@CreateAccount", order = 999)
  public void createAccountPageLogout() {
    myAccountPage.clickLogOut();
  }

  @After(value = "@DeleteAddress", order = 999)
  public void deleteAddressLogout() {
    myAddressPage.clickLogOut();
  }


  @After(value = "@EditInfo", order = 999)
  public void editInfoLogout() {
    identifyPage.clickSingOut();
  }
}
