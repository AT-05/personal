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


  @After(value = "@DeleteAddress,@address", order = 998)
  public void loOutFromMyAddressPage() {
    myAddressPage.clickLogOut();
  }

  @After(value =  ("@Login,@CreateAccount"), order = 999)
  public void loOutFromMyAccountPage() {
    myAccountPage.clickLogOut();
  }

  @After(value = "@EditInfo", order = 999)
  public void loOutFromIdentifyPage() {
    identifyPage.clickSingOut();
  }


}
