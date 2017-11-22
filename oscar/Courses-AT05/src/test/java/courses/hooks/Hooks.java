package courses.hooks;

import courses.sampleapp.ui.HomePage;
import cucumber.api.java.After;

/**
 * Created by Administrator on 11/21/2017.
 */
public class Hooks {

  private HomePage homePage;

  public Hooks(HomePage homePage) {
    this.homePage = homePage;
  }

  //****************************************************************
  //Hooks for @Logout scenarios
  //****************************************************************
  @After(value = "@Logout", order = 999)
  public void afterLoginScenario() {
    System.out.println("\nAfter hook @Logout");
    homePage.logout();
  }

}
