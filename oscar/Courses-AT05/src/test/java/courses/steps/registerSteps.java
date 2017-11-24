package courses.steps;

import static org.testng.Assert.assertEquals;

import courses.sampleapp.entities.Courses;
import courses.sampleapp.entities.User;
import courses.sampleapp.ui.DashboardPage;
import courses.sampleapp.ui.HomePage;
import courses.sampleapp.ui.LoginPage;
import courses.sampleapp.ui.RegisterPage;
import courses.sampleapp.ui.SeleniumCourse;
import courses.sampleapp.ui.SeleniumPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Administrator on 11/21/2017.
 */
public class registerSteps {

  private RegisterPage registerPage;
  private LoginPage loginPage;
  private HomePage homePage;
  private SeleniumPage seleniumPage;
  private SeleniumCourse seleniumCourse;
  private DashboardPage dashboardPage;

  private User user;
  private Courses course;

  public registerSteps(LoginPage loginPage, Courses course) {
    this.loginPage = loginPage;
    this.course = course;
  }

  @And("^I select Create new Account to go to Register page$")
  public void iSelectCreateNewAccountToGoToRegisterPage() {
    registerPage = loginPage.goToRegisterPage();
  }

  @When("^I register with first name, last name, email and password$")
  public void iRegisterWithFirstNameLastNameEmailAndPassword() {
    user = new User();
    user.generateUser();
    homePage = registerPage
        .registerUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
  }

  @When("^I select a free COURSE \"([^\"]*)\"$")
  public void iSelectAFreeCOURSE(String nameCourse) {
    course.setName(nameCourse);
    seleniumPage = homePage.clickSeleniumCourse(course.getName());
  }

  @And("^enroll for free in the COURSE$")
  public void enrollForFreeInTheCOURSE() {
    seleniumCourse = seleniumPage.enrollSeleniumCourse();
  }

  @Then("^the COURSE subscribe should be displayed in My Dashboard$")
  public void theCOURSESubscribeShouldBeDisplayedInMyDashboard() {
    dashboardPage = seleniumCourse.goToDashboard();
    String actualString = dashboardPage.getNameCourse();
    String expectedString = course.getName();
    assertEquals(actualString, expectedString);
  }
}
