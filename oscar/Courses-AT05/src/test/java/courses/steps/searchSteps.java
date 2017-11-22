package courses.steps;

import static org.testng.Assert.assertEquals;

import courses.sampleapp.entities.Courses;
import courses.sampleapp.ui.AllCoursesPage;
import courses.sampleapp.ui.PageTransporter;
import courses.sampleapp.ui.PrincipalPage;
import courses.sampleapp.ui.SearchPage;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by Administrator on 11/21/2017.
 */
public class searchSteps {

  private PrincipalPage principalPage;
  private AllCoursesPage allCoursesPage;
  private SearchPage searchPage;

  private Courses courses;

  public searchSteps(Courses courses) {
    this.courses = courses;
  }

  @Given("^I navigate to all courses page$")
  public void iNavigateToAllCoursesPage()  {
    principalPage = PageTransporter.getInstance().navigateToPrincipalPage();
    allCoursesPage = principalPage.goToAllCoursesPage();
  }

  @When("^I search course with the name \"([^\"]*)\"$")
  public void iSearchCourseWithTheName(String nameCourse) {
    courses.setName(nameCourse);
    searchPage = allCoursesPage.searchCourse(courses.getName());
  }

  @Then("^the course with that name should be displayed$")
  public void theCourseWithThatNameShouldBeDisplayed() {
    String actualString = searchPage.getNameCourse();
    String expectedString = courses.getName();
    assertEquals(actualString, expectedString);
  }
}
