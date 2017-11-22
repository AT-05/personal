package courses.steps;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import courses.sampleapp.entities.User;
import courses.sampleapp.ui.DashboardPage;
import courses.sampleapp.ui.HomePage;
import courses.sampleapp.ui.LoginPage;
import courses.sampleapp.ui.PageTransporter;
import courses.sampleapp.ui.PrincipalPage;
import courses.sampleapp.ui.RegisterPage;
import courses.sampleapp.ui.SeleniumCourse;
import courses.sampleapp.ui.SeleniumPage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Administrator on 11/20/2017.
 */
public class testSteps {

  /*PrincipalPage principalPage;
  LoginPage loginPage;
  HomePage homePage;
  RegisterPage registerPage;
  SeleniumPage seleniumPage;
  SeleniumCourse seleniumCourse;
  DashboardPage dashboardPage;

  User user;

  @When("^I register with first name \"([^\"]*)\", last name \"([^\"]*)\", email \"([^\"]*)\" and password \"([^\"]*)\"$")
  public void iRegisterWithFirstNameLastNameEmailAndPassword(String firstName, String lastName, String email,
      String password) {
    homePage = registerPage.registerUser(firstName, lastName, email, password);
  }

  @And("^I login with email and password valid$")
  public void iLoginWithEmailAndPasswordValid() {
    homePage = loginPage.enterCredentials(user.getEmail(), user.getPassword());
  }*/

}
